package com.jvxie.goshop.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OrderPayTypeEnum {
    PAY_ONLINE(1), // 在线支付
    PAY_OFFLINE(2),   // 货到付款
    ;

    Integer code;

    OrderPayTypeEnum(Integer code) {
        this.code = code;
    }
}
