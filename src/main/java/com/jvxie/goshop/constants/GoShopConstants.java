package com.jvxie.goshop.constants;

/**
 * 项目全局静态常量
 */

public class GoShopConstants {
    public static final String CUSTOMER = "customer";
    public static final String PHONE_REGEXP = "^(13[0-9]|14[5|7]|15[0-9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    public static final String EMAIL_REGEXP = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    public static final Integer SUCCESS_CODE = 0;
    public static final Long  EXPRIE_TIME = (long)60 * 60 * 24 * 7;
}
