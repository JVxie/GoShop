package com.jvxie.goshop.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@Slf4j
public class OrderServiceImplTest extends GoshopApplicationTests {

    @Autowired
    private OrderServiceImpl orderService;

    private Long userId = 695346748889497600L;

    private Long shippingId = 707031620267540480L;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void create() {
        ResponseVo responseVo = orderService.create(userId, shippingId, 1);
        log.info("result = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = orderService.list(userId, 1, 10);
        log.info("result = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo responseVo = orderService.detail(userId, 713794645637464064L);
        log.info("result = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void cancel() {
        ResponseVo responseVo = orderService.cancel(userId, 713794645637464064L);
        log.info("result = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}