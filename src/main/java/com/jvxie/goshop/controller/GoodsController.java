package com.jvxie.goshop.controller;

import com.jvxie.goshop.service.impl.GoodsServiceImpl;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    GoodsServiceImpl goodsService;

    @GetMapping("/goods")
    public ResponseVo goodsList(@RequestParam(value = "goodsTypeId", required = false) Long goodsTypeId,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return goodsService.list(goodsTypeId, pageNum, pageSize);
    }

    @GetMapping("/goods/{goodsId}")
    public ResponseVo goodsDetail(@PathVariable Long goodsId) {
        return goodsService.detail(goodsId);
    }
}
