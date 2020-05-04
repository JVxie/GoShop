package com.jvxie.goshop.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShippingForm {
    /**
     * 收货人姓名
     */
    @NotBlank(message = "收货人姓名不能为空")
    private String shippingName;

    /**
     * 收货人电话
     */
    @NotBlank(message = "收货人电话不能为空")
    private String shippingPhone;

    /**
     * 收获地址省份
     */
    @NotBlank(message = "省份不能为空")
    private String shippingProvince;

    /**
     * 收货地址市区
     */
    @NotBlank(message = "市区不能为空")
    private String shippingCity;

    /**
     * 收获地址区/县/街道
     */
    @NotBlank(message = "区/县/街道不能为空")
    private String shippingDistrict;

    /**
     * 收货地址详细
     */
    @NotBlank(message = "详细地址不能为空")
    private String shippingAddress;

    /**
     * 收货地址邮编
     */
    @NotBlank(message = "邮编不能为空")
    private String shippingZip;
}
