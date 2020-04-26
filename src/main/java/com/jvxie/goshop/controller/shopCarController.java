package com.jvxie.goshop.controller;

import com.jvxie.goshop.constants.CookieConstants;
import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.service.impl.ShopCarServiceImpl;
import com.jvxie.goshop.utils.CookieUtil;
import com.jvxie.goshop.vo.ResponseVo;
import com.jvxie.goshop.vo.ShopCarVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class shopCarController {
    @Autowired
    ShopCarServiceImpl shopCarService;

    @PostMapping("/shop_car")
    public ResponseVo add(@Valid @RequestBody ShopCarAddForm shopCarAddForm,
                          HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        shopCarService.add(uid, shopCarAddForm);
        return shopCarService.list(uid);
    }

    @GetMapping("/shop_car")
    public ResponseVo list(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        return shopCarService.list(uid);
    }

    @PutMapping("/shop_car/{goodsId}")
    public ResponseVo update(@PathVariable Long goodsId,
                             @Valid @RequestBody ShopCarUpdateForm shopCarUpdateForm,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        shopCarService.update(uid, goodsId, shopCarUpdateForm);
        return shopCarService.list(uid);
    }

    @DeleteMapping("/shop_car/{goodsId}")
    public ResponseVo update(@PathVariable Long goodsId,
                             HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        shopCarService.delete(uid, goodsId);
        return shopCarService.list(uid);
    }

    @PutMapping("/shop_car/selectAll")
    public ResponseVo selcetAll(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        shopCarService.selectAll(uid);
        return shopCarService.list(uid);
    }

    @PutMapping("/shop_car/unSelectAll")
    public ResponseVo unSelcetAll(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        shopCarService.unSelectAll(uid);
        return shopCarService.list(uid);
    }

    @GetMapping("/shop_car/goods/sum")
    public ResponseVo sum(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        Long uid = Long.valueOf(cookie.getValue());
        return shopCarService.sum(uid);
    }
}
