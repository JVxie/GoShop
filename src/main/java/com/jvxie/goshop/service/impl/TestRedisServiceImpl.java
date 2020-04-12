package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.service.ITestRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class TestRedisServiceImpl implements ITestRedisService {

    @Autowired
    @Qualifier("redisTemplateUser")
    StringRedisTemplate redisTemplateUser;

    @Autowired
    @Qualifier("redisTemplateShopCar")
    StringRedisTemplate redisTemplateShopCar;

    @Override
    public void testRedisUser() {
        redisTemplateUser.opsForValue().set("123", "123", 7200, TimeUnit.SECONDS);
    }

    @Override
    public void testRedisShopCar() {
        redisTemplateShopCar.opsForValue().set("321", "321", 7200, TimeUnit.SECONDS);
    }
}
