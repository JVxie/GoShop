package com.jvxie.goshop.controller;

import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.constants.CookieConstants;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.form.OrderCreateForm;
import com.jvxie.goshop.service.IOrderService;
import com.jvxie.goshop.service.impl.OrderServiceImpl;
import com.jvxie.goshop.utils.CookieUtil;
import com.jvxie.goshop.vo.OrderVo;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.ws.Response;

@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    @Qualifier("redisTemplateUser")
    StringRedisTemplate redisTemplateUser;

    @PostMapping("/orders")
    private ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                       HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return orderService.create(userId, form.getShippingId(), form.getPayType());
    }

    @GetMapping("/orders")
    private ResponseVo<PageInfo> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                      HttpServletRequest request) {

        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return orderService.list(userId, pageNum, pageSize);
    }

    @GetMapping("/orders/{orderId}")
    private ResponseVo<OrderVo> detail(@PathVariable Long orderId,
                                       HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return orderService.detail(userId, orderId);
    }

    @PutMapping("/orders/{orderId}")
    private ResponseVo cancel(@PathVariable Long orderId,
                              HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return orderService.cancel(userId, orderId);
    }
}
