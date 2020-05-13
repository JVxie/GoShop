package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.enums.GoodsStatusEnum;
import com.jvxie.goshop.enums.IdGeneratorEnum;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.form.OrderForm;
import com.jvxie.goshop.mapper.GoodsMapper;
import com.jvxie.goshop.mapper.ShippingMapper;
import com.jvxie.goshop.model.*;
import com.jvxie.goshop.service.IOrderService;
import com.jvxie.goshop.utils.IdGeneratorUtil;
import com.jvxie.goshop.vo.OrderVo;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ShopCarServiceImpl shopCarService;

    @Override
    public ResponseVo<OrderVo> create(Long userId, OrderForm form) {
        IdGeneratorUtil idGeneratorUtilOrder = new IdGeneratorUtil(IdGeneratorEnum.ORDER);
        IdGeneratorUtil idGeneratorUtilOrderInfo = new IdGeneratorUtil(IdGeneratorEnum.ORDER_INFO);
        // 收货地址校验
        Shipping shipping = shippingMapper.selectByUserIdAndShippingId(userId, form.getShippingId());
        if (shipping == null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_FOUND);
        }
        // 获取购物车，对选中商品校验（是否有该商品、库存充足）
        List<ShopCar> shopCarList = shopCarService.listForShopCar(userId)
                .stream()
                .filter(ShopCar::getSelected)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(shopCarList)) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_FOUND);
        }
        Set<Long> goodsIdSet = shopCarList.stream().map(ShopCar::getGoodsId).collect(Collectors.toSet());
        List<Goods> goodsList = goodsMapper.selectByGoodsIdSet(goodsIdSet);
        Map<Long, Goods> goodsMap = goodsList.stream().
                collect(Collectors.toMap(Goods::getGoodsId, goods -> goods));
        for (ShopCar shopCar : shopCarList) {
            Goods goods = goodsMap.get(shopCar.getGoodsId());
            // 数据库中是否有该商品
            if (goods == null) {
                return ResponseVo.error(ResponseEnum.GOODS_NOT_FOUND, "商品不存在，商品ID：" + shopCar.getGoodsId());
            }
            // 商品是否还在售
            if (GoodsStatusEnum.ON_SALE.getCode().equals(goods.getGoodsStatus())) {
                return ResponseVo.error(ResponseEnum.GOODS_OFF_SALE_OR_DELETE, goods.getGoodsTitle() + "不是在售状态");
            }
            // 库存是否充足
            if (goods.getGoodsCount() < shopCar.getQuantity()) {
                return ResponseVo.error(ResponseEnum.GOODS_COUNT_ERROR, goods.getGoodsTitle() + "库存不正确");
            }

//            buildOrderInfo(userId,)
        }
        // 计算总价，仅选中的商品
        // 生产订单，入库：Order和OrderInfo，事物

        // 减库存

        // 更新购物车，删除已下单商品
        return null;
    }

    private OrderInfo buildOrderInfo(Long userId,
                                     Long orderId,
                                     Goods goods,
                                     Integer quantity) {
        OrderInfo info = new OrderInfo();
        info.setOrderId(orderId);
        info.setUserId(userId);
        info.setOrignGoodsId(goods.getGoodsId());
        info.setOrignGoodsTitle(goods.getGoodsTitle());
        info.setOrignGoodsImg(goods.getGoodsImg());
        info.setOrignGoodsPrice(goods.getGoodsPrice());
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
        order.setOrderCost();
        order.setOrderPayType(payType);
        order.setOrderPostage();
        order.setOrderStatus();
        return order;
    }
}
