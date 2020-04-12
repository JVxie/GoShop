package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.GoshopApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TestRedisServiceImplTest extends GoshopApplicationTests {

    @Autowired
    TestRedisServiceImpl testRedisService;

    @Test
    public void testRedisUser() {
        testRedisService.testRedisUser();
    }

    @Test
    public void testRedisShopCar() {
        testRedisService.testRedisShopCar();
    }
}