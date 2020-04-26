package com.jvxie.goshop.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.vo.ResponseVo;
import com.jvxie.goshop.vo.ShopCarVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.junit.Assert.*;

@Slf4j
public class ShopCarServiceImplTest extends GoshopApplicationTests {

    @Autowired
    ShopCarServiceImpl shopCarService;

    @Autowired
    @Qualifier("redisTemplateShopCar")
    StringRedisTemplate redisTemplate;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void add() {
        ShopCarAddForm shopCarAddForm = new ShopCarAddForm();
        shopCarAddForm.setGoodsId(700017327848030208L);
        shopCarAddForm.setSelected(true);
        ResponseVo list = shopCarService.add(123L, shopCarAddForm);
        log.info("list = {}", gson.toJson(list));
    }


    @Test
    public void list() {
        ResponseVo list = shopCarService.list(123L);
        log.info("list = {}", gson.toJson(list));
    }

    @Test
    public void test() {
        Long size = redisTemplate.opsForHash().size(String.format(RedisConstants.SHOP_CAR_PREFIX, 123L));
        log.info("size = {}", size);
    }

    @Test
    public void update() {
        ShopCarUpdateForm form = new ShopCarUpdateForm();
        form.setQuantity(10);
        form.setSelected(true);
        ResponseVo list = shopCarService.update(123L, 700017327848030208L, form);
        log.info("list = {}", gson.toJson(list));
    }

    @Test
    public void delete() {
        ResponseVo list = shopCarService.delete(123L, 700017327869001728L);
        log.info("list = {}", gson.toJson(list));
    }

    @Test
    public void selectAll() {
        ResponseVo list = shopCarService.selectAll(123L);
        log.info("list = {}", gson.toJson(list));
    }

    @Test
    public void unSelectAll() {
        ResponseVo list = shopCarService.unSelectAll(123L);
        log.info("list = {}", gson.toJson(list));
    }

    @Test
    public void sum() {
        ResponseVo list = shopCarService.sum(123L);
        log.info("list = {}", gson.toJson(list));
    }
}