package com.jvxie.goshop.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderForm {
    Long shippingId;

    Integer OrderPayType;

    BigDecimal postage;
}
