package com.jvxie.goshop.service;

import com.jvxie.goshop.vo.OrderVo;
import com.jvxie.goshop.vo.ResponseVo;

public interface IOrderService {
    ResponseVo<OrderVo> create(Long userId, Long shippingId);
}
