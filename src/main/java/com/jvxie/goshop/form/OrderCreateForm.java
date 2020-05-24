package com.jvxie.goshop.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderCreateForm {
    @NotNull(message = "收货地址不能为空")
    private Long shippingId;

    @NotNull(message = "支付方式不能为空")
    private Integer payType;
}
