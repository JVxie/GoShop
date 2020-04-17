package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.model.Goods;
import com.jvxie.goshop.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Slf4j
public class GoodsServiceImplTest extends GoshopApplicationTests {

    @Autowired
    GoodsServiceImpl goodsService;

    @Test
    public void list() {
        ResponseVo responseVo = goodsService.list(699286295570153472L, 2, 3);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void insertGoods() {
        int MAX_N = 4;
        Goods[] goods = new Goods[MAX_N];
        for (int i = 0; i < MAX_N; ++i)
            goods[i] = new Goods();
        goods[0].setGoodsTitle("男士黑色T恤");
        goods[0].setGoodsTypeId(699289030684180480L);
        goods[0].setGoodsCount(1);
        goods[0].setGoodsOldPrice(BigDecimal.TEN);
        goods[0].setGoodsPrice(BigDecimal.TEN);

        goods[1].setGoodsTitle("女士黄色连衣裙");
        goods[1].setGoodsTypeId(699288459860377600L);
        goods[1].setGoodsCount(1);
        goods[1].setGoodsOldPrice(BigDecimal.TEN);
        goods[1].setGoodsPrice(BigDecimal.TEN);

        goods[2].setGoodsTitle("G-SHOCK 黑金时尚电子手表");
        goods[2].setGoodsTypeId(699300218742636544L);
        goods[2].setGoodsCount(1);
        goods[2].setGoodsOldPrice(BigDecimal.TEN);
        goods[2].setGoodsPrice(BigDecimal.TEN);

        goods[3].setGoodsTitle("可口可乐500ml");
        goods[3].setGoodsTypeId(699286296060887040L);
        goods[3].setGoodsCount(1);
        goods[3].setGoodsOldPrice(BigDecimal.TEN);
        goods[3].setGoodsPrice(BigDecimal.TEN);
        for (int i = 0; i < MAX_N; ++i)
            goodsService.insertGoods(goods[i]);
    }

    @Test
    public void detail() {
//        log.info();
        ResponseVo responseVo =  goodsService.detail(700015772776267776L);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}