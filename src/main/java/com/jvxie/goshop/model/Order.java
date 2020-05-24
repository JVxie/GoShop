package com.jvxie.goshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order
 * @author 
 */
@Data
public class Order implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 订单ID（订单号）
     */
    private Long orderId;

    /**
     * 订单所属用户ID
     */
    private Long userId;

    /**
     * 订单总金额
     */
    private BigDecimal orderCost;

    /**
     * 订单邮费
     */
    private BigDecimal orderPostage;

    /**
     * 订单状态，1：待支付，2：待收货，3：待评价，4：已退款，5：已关闭，6：已完成
     */
    private Integer orderStatus;

    /**
     * 订单支付时间
     */
    private Date orderPayTime;

    /**
     * 订单发货时间
     */
    private Date orderSendTime;

    /**
     * 订单完成时间
     */
    private Date orderEndTime;

    /**
     * 订单关闭时间
     */
    private Date orderCloseTime;

    /**
     * 支付方式，1：在线支付，2：货到付款
     */
    private Integer orderPayType;

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

    private static final long serialVersionUID = 1L;
}