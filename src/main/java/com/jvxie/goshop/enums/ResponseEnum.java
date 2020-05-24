package com.jvxie.goshop.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    ERROR(-1, "服务端异常"),
    SUCCESS(0, "成功"),
    PASS_ERROR(1, "密码错误"),
    USER_PHONE_EXIST(2, "手机号已注册"),
    USER_EMAIL_EXIST(3, "邮箱已注册"),
    GOODS_NOT_FOUND(4, "商品不存在"),
    GOODS_OFF_SALE_OR_DELETE(5, "商品下架或删除"),
    GOODS_COUNT_ERROR(6, "商品库存不正确"),
    SHOP_CAR_EXCEEDED(7, "购物车最多可添加120件商品，请清理后添加"),
    SHOP_CAR_GOODS_NOTFOUND(8, "购物车内无此商品，不可修改"),
    FAIL(9, "失败"),
    NEED_LOGIN(10, "用户未登录，请先登录"),
    PARAM_ERROR(11, "参数错误"),
    LOGIN_NAME_OR_PASSWORD_ERROR(12, "登录名或密码错误"),
    USER_NOT_FOUND(13, "用户不存在"),
    USER_LOGIN_EXIST(14, "用户已经登录"),
    SHIPPING_NOT_FOUND(15, "收货地址不存在"),
    ORDER_NOT_FOUND(16, "订单不存在"),
    ORDER_STATUS_ERROR(17, "订单状态有误"),
    SHOP_CAR_UNSELECTED(18, "购物车无选中商品"),
    ;

    Integer code;
    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
