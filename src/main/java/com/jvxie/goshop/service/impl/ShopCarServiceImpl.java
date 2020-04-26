package com.jvxie.goshop.service.impl;

import com.google.gson.Gson;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.enums.GoodsStatusEnum;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.mapper.GoodsMapper;
import com.jvxie.goshop.model.Goods;
import com.jvxie.goshop.model.ShopCar;
import com.jvxie.goshop.service.IShopCarService;
import com.jvxie.goshop.vo.ResponseVo;
import com.jvxie.goshop.vo.ShopCarGoodsVo;
import com.jvxie.goshop.vo.ShopCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ShopCarServiceImpl implements IShopCarService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    @Qualifier("redisTemplateShopCar")
    StringRedisTemplate redisTemplateShopCar;

    private Gson gson = new Gson();

    @Override
    public ResponseVo add(Long uid, ShopCarAddForm form) {
        // 此方法在默认只新增一件
        // 判断商品是否存在
        Goods goods = goodsMapper.selectByGoodsId(form.getGoodsId());
        Integer quantity = form.getQuantity() == null ? RedisConstants.SHOP_CAR_QUANTITY : form.getQuantity();
        if (goods == null) {
            return ResponseVo.error(ResponseEnum.GOODS_NOT_FOUND);
        }
        // 判断商品是否在售
        if (!goods.getGoodsStatus().equals(GoodsStatusEnum.ON_SALE.getCode())) {
            return ResponseVo.error(ResponseEnum.GOODS_OFF_SALE_OR_DELETE);
        }
        // 判断库存是否充足
        if (goods.getGoodsCount() < quantity) {
            return ResponseVo.error(ResponseEnum.GOODS_COUNT_ERROR);
        }
        // 从redis读取数据
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);
        String redisValue = opsForHash.get(redisKey, String.valueOf(goods.getGoodsId()));
        ShopCar shopCar;
        if (StringUtils.isEmpty(redisValue)) {
            // redis（或者说购物车）里没有该商品
            if (opsForHash.size(redisKey) >= 120) {
                // 如果购物车总数量超过120件
                return ResponseVo.error(ResponseEnum.SHOP_CAR_EXCEEDED);
            }
            shopCar = new ShopCar(goods.getGoodsId(), quantity, form.getSelected());
        } else {
            shopCar = gson.fromJson(redisValue, ShopCar.class);
            shopCar.setQuantity(shopCar.getQuantity() + quantity);
        }
        opsForHash.put(
                redisKey,
                String.valueOf(goods.getGoodsId()),
                gson.toJson(shopCar)
        );
        return list(uid);
    }

    @Override
    public ResponseVo list(Long uid) {
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);
        Map<String, String> entries = opsForHash.entries(redisKey);
        Set<Long> goodsIdSet = new HashSet<>();
        List<ShopCar> shopCarList = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            Long goodsId = Long.valueOf(entry.getKey());
            ShopCar shopCar = gson.fromJson(entry.getValue(), ShopCar.class);
            goodsIdSet.add(goodsId);
            shopCarList.add(shopCar);
        }
        List<Goods> goodsList = goodsMapper.selectByGoodsIdSet(goodsIdSet);
        Boolean selectAll = true;
        Integer totalQuantity = 0;
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<ShopCarGoodsVo> shopCarGoodsVoList = new ArrayList<>();
        for (Goods goods : goodsList) {
            for (ShopCar shopCar : shopCarList) {
                if (shopCar.getGoodsId().equals(goods.getGoodsId())) {
                    ShopCarGoodsVo shopCarGoodsVo = new ShopCarGoodsVo(
                            shopCar.getGoodsId(),
                            shopCar.getQuantity(),
                            goods.getGoodsTitle(),
                            goods.getGoodsImg(),
                            goods.getGoodsPrice(),
                            goods.getGoodsStatus(),
                            goods.getGoodsPrice().multiply(BigDecimal.valueOf(shopCar.getQuantity())),
                            goods.getGoodsCount(),
                            shopCar.getSelected()
                    );
                    shopCarGoodsVoList.add(shopCarGoodsVo);
                    if (!shopCar.getSelected()) {
                        selectAll = false;
                    }
                    if (shopCar.getSelected()){
                        totalPrice = totalPrice.add(shopCarGoodsVo.getGoodsTotalPrice());
                    }
                    totalQuantity += shopCar.getQuantity();
                }
            }
        }
        ShopCarVo shopCarVo = new ShopCarVo();
        shopCarVo.setShopCarGoodsVoList(shopCarGoodsVoList);
        shopCarVo.setSelectAll(selectAll);
        shopCarVo.setShopCarTotalQuantity(totalQuantity);
        shopCarVo.setShopCarTotalPrice(totalPrice);
        return ResponseVo.success(shopCarVo);
    }

    @Override
    public ResponseVo update(Long uid, Long goodsId, ShopCarUpdateForm shopCarUpdateForm) {
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);
        String redisValue = opsForHash.get(redisKey, String.valueOf(goodsId));
        if (StringUtils.isEmpty(redisValue)) {
            // redis（或者说购物车）里没有该商品
            return ResponseVo.error(ResponseEnum.SHOP_CAR_GOODS_NOTFOUND);
        }
        ShopCar shopCar = gson.fromJson(redisValue, ShopCar.class);
        Goods goods = goodsMapper.selectByGoodsId(shopCar.getGoodsId());
        if (shopCarUpdateForm.getQuantity() != null && goods.getGoodsCount() < shopCarUpdateForm.getQuantity()) {
            return ResponseVo.error(ResponseEnum.GOODS_COUNT_ERROR);
        }
        if (shopCarUpdateForm.getQuantity() != null && shopCarUpdateForm.getQuantity() >= 0)
            shopCar.setQuantity(shopCarUpdateForm.getQuantity());
        if (shopCarUpdateForm.getSelected() != null) {
            shopCar.setSelected(shopCarUpdateForm.getSelected());
        }
        opsForHash.put(
                redisKey,
                String.valueOf(goodsId),
                gson.toJson(shopCar)
        );
        return list(uid);
    }

    @Override
    public ResponseVo delete(Long uid, Long goodsId) {
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);
        String redisValue = opsForHash.get(redisKey, String.valueOf(goodsId));
        if (StringUtils.isEmpty(redisValue)) {
            // redis（或者说购物车）里没有该商品
            return ResponseVo.error(ResponseEnum.SHOP_CAR_GOODS_NOTFOUND);
        }

        opsForHash.delete(
                redisKey,
                String.valueOf(goodsId)
        );
        return list(uid);
    }

    @Override
    public ResponseVo selectAll(Long uid) {
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);

        for (ShopCar shopCar : listForShopCar(uid)) {
            shopCar.setSelected(true);
            opsForHash.put(
                    redisKey,
                    String.valueOf(shopCar.getGoodsId()),
                    gson.toJson(shopCar)
            );
        }
        return list(uid);
    }

    @Override
    public ResponseVo unSelectAll(Long uid) {
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);

        for (ShopCar shopCar : listForShopCar(uid)) {
            shopCar.setSelected(false);
            opsForHash.put(
                    redisKey,
                    String.valueOf(shopCar.getGoodsId()),
                    gson.toJson(shopCar)
            );
        }
        return list(uid);
    }

    @Override
    public ResponseVo sum(Long uid) {
        Integer sum = listForShopCar(uid)
                .stream()
                .map(ShopCar::getQuantity)
                .reduce(0, Integer::sum);
        return ResponseVo.success(sum);
    }

    private List<ShopCar> listForShopCar(Long uid) {
        HashOperations<String, String, String> opsForHash = redisTemplateShopCar.opsForHash();
        String redisKey = String.format(RedisConstants.SHOP_CAR_PREFIX, uid);
        Map<String, String> entries = opsForHash.entries(redisKey);
        List<ShopCar> shopCarList = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            shopCarList.add(gson.fromJson(entry.getValue(), ShopCar.class));
        }
        return shopCarList;
    }
}
