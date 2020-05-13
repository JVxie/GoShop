package com.jvxie.goshop.controller;

import com.jvxie.goshop.constants.CookieConstants;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.form.ShippingForm;
import com.jvxie.goshop.service.impl.ShippingServiceImpl;
import com.jvxie.goshop.utils.CookieUtil;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class ShippingController {
    @Autowired
    ShippingServiceImpl shippingService;

    @Autowired
    @Qualifier("redisTemplateUser")
    StringRedisTemplate redisTemplateUser;

    @PostMapping("/shippings")
    public ResponseVo add(@Valid @RequestBody ShippingForm form,
                          HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shippingService.add(userId, form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Long shippingId,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shippingService.delete(userId, shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Long shippingId,
                             @Valid @RequestBody ShippingForm form,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shippingService.update(userId, shippingId, form);
    }

    @GetMapping("/shippings")
    public ResponseVo list(HttpServletRequest request,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shippingService.list(userId, pageNum, pageSize);
    }
}
