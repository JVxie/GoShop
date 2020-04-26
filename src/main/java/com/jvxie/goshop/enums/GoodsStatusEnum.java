package com.jvxie.goshop.enums;

import lombok.Getter;

@Getter
public enum GoodsStatusEnum {
    OFF_SALE(0),
    ON_SALE(1),
    DELETE(2),
    ;

    private Integer code;
    GoodsStatusEnum(Integer code) {
        this.code = code;
    }
}
