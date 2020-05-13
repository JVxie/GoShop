package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.vo.ResponseVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderServiceImplTest extends GoshopApplicationTests {

    @Autowired
    private OrderServiceImpl orderService;

    private Long userId = 695346748889497600L;

    private Long shippingId = 707031620267540480L;

    @Test
    public void create() {
        ResponseVo responseVo = orderService.create(userId, shippingId);
    }
}