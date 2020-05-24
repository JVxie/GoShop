package com.jvxie.goshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.enums.GoodsStatusEnum;
import com.jvxie.goshop.enums.IdGeneratorEnum;
import com.jvxie.goshop.enums.OrderStatusEnum;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.form.OrderForm;
import com.jvxie.goshop.mapper.GoodsMapper;
import com.jvxie.goshop.mapper.OrderInfoMapper;
import com.jvxie.goshop.mapper.OrderMapper;
import com.jvxie.goshop.mapper.ShippingMapper;
import com.jvxie.goshop.model.*;
import com.jvxie.goshop.service.IOrderService;
import com.jvxie.goshop.utils.IdGeneratorUtil;
import com.jvxie.goshop.vo.OrderInfoVo;
import com.jvxie.goshop.vo.OrderVo;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ShopCarServiceImpl shopCarService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    @Transactional // 事务注解
    public ResponseVo<OrderVo> create(Long userId, Long shippingId, Integer payType) {
        IdGeneratorUtil idGeneratorUtilOrder = new IdGeneratorUtil(IdGeneratorEnum.ORDER);
        // 收货地址校验
        Shipping shipping = shippingMapper.selectByUserIdAndShippingId(userId,shippingId);
        if (shipping == null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_FOUND);
        }
        // 获取购物车，对选中商品校验（是否有该商品、库存充足）
        List<ShopCar> shopCarList = shopCarService.listForShopCar(userId)
                .stream()
                .filter(ShopCar::getSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(shopCarList)) {
            return ResponseVo.error(ResponseEnum.SHOP_CAR_UNSELECTED);
        }
        Set<Long> goodsIdSet = shopCarList.stream().map(ShopCar::getGoodsId).collect(Collectors.toSet());
        List<Goods> goodsList = goodsMapper.selectByGoodsIdSet(goodsIdSet);
        Map<Long, Goods> goodsMap = goodsList.stream().
                collect(Collectors.toMap(Goods::getGoodsId, goods -> goods));
        List<OrderInfo> orderInfoList = new ArrayList<>();
        // 生成OrderId
        Long orderId = idGeneratorUtilOrder.nextId();
        for (ShopCar shopCar : shopCarList) {
            Goods goods = goodsMap.get(shopCar.getGoodsId());
            // 数据库中是否有该商品
            if (goods == null) {
                return ResponseVo.error(ResponseEnum.GOODS_NOT_FOUND, "商品不存在，商品ID：" + shopCar.getGoodsId());
            }
            // 商品是否还在售
            if (!GoodsStatusEnum.ON_SALE.getCode().equals(goods.getGoodsStatus())) {
                return ResponseVo.error(ResponseEnum.GOODS_OFF_SALE_OR_DELETE, goods.getGoodsTitle() + "不是在售状态");
            }
            // 库存是否充足
            if (goods.getGoodsCount() < shopCar.getQuantity()) {
                return ResponseVo.error(ResponseEnum.GOODS_COUNT_ERROR, goods.getGoodsTitle() + "库存不正确");
            }
            OrderInfo orderInfo = buildOrderInfo(userId, orderId, goods, shopCar.getQuantity());
            orderInfoList.add(orderInfo);
            // 减库存
            goods.setGoodsCount(goods.getGoodsCount() - shopCar.getQuantity());
            int rowOfGoods = goodsMapper.updateByGoodsId(goods);
            if (rowOfGoods <= 0) {
                return ResponseVo.error(ResponseEnum.ERROR);
            }
        }
        // 计算总价，仅选中的商品
        // 生产订单，入库：Order和OrderInfo
        Order order = buildOrder(userId, orderId, shipping, payType, orderInfoList);

        int rowOfOrder = orderMapper.insertSelective(order);
        if (rowOfOrder <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        int rowOfOrderInfo = orderInfoMapper.batchInsert(orderInfoList);
        if (rowOfOrderInfo <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        // 更新购物车，删除已下单商品
        // Redis不能回滚
        for (ShopCar shopCar : shopCarList) {
            shopCarService.delete(userId, shopCar.getGoodsId());
        }
        // 构造Vo对象
        OrderVo orderVo = buildOrderVo(order, orderInfoList);
        return ResponseVo.success(orderVo);
    }

    private OrderVo buildOrderVo(Order order, List<OrderInfo> orderInfoList) {
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(order, orderVo);
        List<OrderInfoVo> orderInfoVoList = orderInfoList.stream().map(e -> {
            OrderInfoVo orderInfoVo = new OrderInfoVo();
            BeanUtils.copyProperties(e, orderInfoVo);
            return orderInfoVo;
        }).collect(Collectors.toList());
        orderVo.setOrderInfoVoList(orderInfoVoList);
        return orderVo;
    }

    private OrderInfo buildOrderInfo(Long userId,
                                     Long orderId,
                                     Goods goods,
                                     Integer quantity) {
        IdGeneratorUtil idGeneratorUtilOrderInfo = new IdGeneratorUtil(IdGeneratorEnum.ORDER_INFO);
        OrderInfo info = new OrderInfo();
        info.setOrderInfoId(idGeneratorUtilOrderInfo.nextId());
        info.setOrderId(orderId);
        info.setUserId(userId);
        BeanUtils.copyProperties(goods, info);
        info.setQuantity(quantity);
        info.setTotalPrice(goods.getGoodsPrice().multiply(BigDecimal.valueOf(quantity)));
        return info;
    }

    private Order buildOrder(Long userId,
                             Long orderId,
                             Shipping shipping,
                             Integer payType,
                             List<OrderInfo> orderInfoList) {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderId(orderId);
        BeanUtils.copyProperties(shipping, order);

        BigDecimal cost = orderInfoList.stream()
                .map(OrderInfo::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setOrderCost(cost);

        order.setOrderPayType(payType);
        // TODO 邮费后期要改，不可能全是包邮
        order.setOrderPostage(BigDecimal.ZERO);
        order.setOrderStatus(OrderStatusEnum.NO_PAY.getCode());
        return order;
    }

    @Override
    public ResponseVo<PageInfo> list(Long userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectByUserId(userId);
        Set<Long> orderIdSet = orderList.stream().map(Order::getOrderId).collect(Collectors.toSet());
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByOrderIdSet(orderIdSet);
        Map<Long, List<OrderInfo>> orderInfoMap = orderInfoList.stream()
                .collect(Collectors.groupingBy(OrderInfo::getOrderId));
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderVo orderVo = buildOrderVo(order, orderInfoMap.get(order.getOrderId()));
            orderVoList.add(orderVo);
        }
        PageInfo pageInfo = new PageInfo<>(orderList);
        pageInfo.setList(orderVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<OrderVo> detail(Long userId, Long orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        if (order == null || !order.getUserId().equals(userId)) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_FOUND);
        }
        Set<Long> orderIdSet = new HashSet<>();
        orderIdSet.add(orderId);
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByOrderIdSet(orderIdSet);

        OrderVo orderVo = buildOrderVo(order, orderInfoList);
        return ResponseVo.success(orderVo);
    }

    @Override
    public ResponseVo cancel(Long userId, Long orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        if (order == null || !order.getUserId().equals(userId)) {
            return ResponseVo.error(ResponseEnum.ORDER_NOT_FOUND);
        }
        if (!order.getOrderStatus().equals(OrderStatusEnum.NO_PAY.getCode())) {
            return ResponseVo.error(ResponseEnum.ORDER_STATUS_ERROR);
        }
        order.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
        order.setOrderCloseTime(new Date());
        int row = orderMapper.updateByOrderId(order);
        if (row <= 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }
}
