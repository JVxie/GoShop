package com.jvxie.goshop.controller;


import com.jvxie.goshop.service.impl.GoodsTypeServiceImpl;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsTypeController {
    @Autowired
    GoodsTypeServiceImpl goodsTypeService;

    @GetMapping("/goodsType")
    private ResponseVo goodsType() {
        return goodsTypeService.selectAll();
    }
}
