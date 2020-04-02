package com.jvxie.goshop.enums;

import lombok.Getter;

@Getter
public enum UserGroupEnum {

    ADMIN(0),
    CUSTOMER(1),
    MERCHANT(2),
    ;

    private Integer code;

    UserGroupEnum(Integer code) {
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
