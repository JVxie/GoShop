package com.jvxie.goshop.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    ERROR(-1, "服务端异常"),
    SUCCESS(0, "成功"),
    PASS_ERROR(1, "密码错误"),
    USER_PHONE_EXIST(2, "手机号已注册"),
    USER_EMAIL_EXIST(3, "邮箱已注册"),
    NEED_LOGIN(10, "用户未登录，请先登录"),
    PARAM_ERROR(11, "参数错误"),
    LOGINNAME_OR_PASSWORD_ERROR(12, "登录名或密码错误"),
    ;

    Integer code;
    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
