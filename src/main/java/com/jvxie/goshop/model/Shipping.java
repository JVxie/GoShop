package com.jvxie.goshop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * shipping
 * @author 
 */
@Data
public class Shipping implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 收货地址ID
     */
    private Long shippingId;

    /**
     * 收货地址所属user_id
     */
    private Long userId;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;
}