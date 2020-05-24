package com.jvxie.goshop.service;

import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.form.OrderForm;
import com.jvxie.goshop.vo.OrderVo;
import com.jvxie.goshop.vo.ResponseVo;

public interface IOrderService {
    ResponseVo<OrderVo> create(Long userId, Long shippingId, Integer payType);

    ResponseVo<PageInfo> list(Long userId, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Long userId, Long orderId);

    ResponseVo cancel(Long userId, Long orderId);
}
