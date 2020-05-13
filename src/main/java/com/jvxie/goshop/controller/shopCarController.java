package com.jvxie.goshop.controller;

import com.jvxie.goshop.constants.CookieConstants;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.service.impl.ShopCarServiceImpl;
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
public class shopCarController {
    @Autowired
    ShopCarServiceImpl shopCarService;

    @Autowired
    @Qualifier("redisTemplateUser")
    StringRedisTemplate redisTemplateUser;

    @GetMapping("/shopCar")
    public ResponseVo list(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.list(userId);
    }

    @PostMapping("/shopCar")
    public ResponseVo add(@Valid @RequestBody ShopCarAddForm shopCarAddForm,
                          HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.add(userId, shopCarAddForm);
    }

    @PutMapping("/shopCar/{goodsId}")
    public ResponseVo update(@PathVariable Long goodsId,
                             @Valid @RequestBody ShopCarUpdateForm shopCarUpdateForm,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.update(userId, goodsId, shopCarUpdateForm);
    }

    @DeleteMapping("/shopCar/{goodsId}")
    public ResponseVo update(@PathVariable Long goodsId,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.delete(userId, goodsId);
    }

    @PutMapping("/shopCar/selectAll")
    public ResponseVo selcetAll(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.selectAll(userId);
    }

    @PutMapping("/shopCar/unSelectAll")
    public ResponseVo unSelcetAll(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.unSelectAll(userId);
    }

    @GetMapping("/shopCar/goods/sum")
    public ResponseVo sum(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String tokenFromRedis = redisTemplateUser.opsForValue().get(
                String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue())
        );
        Long userId = Long.valueOf(tokenFromRedis);
        return shopCarService.sum(userId);
    }
}
