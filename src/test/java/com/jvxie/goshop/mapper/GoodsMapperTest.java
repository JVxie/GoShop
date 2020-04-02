package com.jvxie.goshop.mapper;

import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.model.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class GoodsMapperTest extends GoshopApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void selectByPrimaryKey() {
        Goods goods = goodsMapper.selectByPrimaryKey(1);
        System.out.println(goods);
    }
}