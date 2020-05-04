package com.jvxie.goshop.service;

import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.form.ShippingForm;
import com.jvxie.goshop.model.Shipping;
import com.jvxie.goshop.vo.ResponseVo;

public interface IShippingService {
    ResponseVo add(Long userId, ShippingForm form);

    ResponseVo delete(Long userId, Long shippingId);

    ResponseVo update(Long userId, Long shippingId, ShippingForm form);

    ResponseVo<PageInfo> list(Long userId, Integer pageNum, Integer pageSize);
}
