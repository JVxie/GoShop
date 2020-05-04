package com.jvxie.goshop.vo;

import lombok.Data;

@Data
public class ShippingVo {
    /**
     * 收货地址ID
     */
    private Long shippingId;

    /**
     * 收货人姓名
     */
    private String shippingName;

    /**
     * 收货人电话
     */
    private String shippingPhone;

    /**
     * 收获地址省份
     */
    private String shippingProvince;

    /**
     * 收货地址市区
     */
    private String shippingCity;

    /**
     * 收获地址区/县/街道
     */
    private String shippingDistrict;

    /**
     * 收货地址详细
     */
    private String shippingAddress;

    /**
     * 收货地址邮编
     */
    private String shippingZip;
}
