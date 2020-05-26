package com.jvxie.goshop.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderPay {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 订单支付信息ID
     */
    private Long orderPayId;

    /**
     * 订单支付信息所属订单ID
     */
    private Long orderId;

    /**
     * 支付方式：1、支付宝，2、微信
     */
    private Integer orderPayPlatform;

    /**
     * 支付返回信息码
     */
    private String orderPayNumber;

    /**
     * 支付金额
     */
    private BigDecimal orderAmount;

    /**
     * 支付状态
     */
    private String orderPayStatus;

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

    public OrderPay(Long orderPayId, Long orderId, Integer orderPayPlatform, BigDecimal orderAmount, String orderPayStatus) {
        this.orderPayId = orderPayId;
        this.orderId = orderId;
        this.orderPayPlatform = orderPayPlatform;
        this.orderAmount = orderAmount;
        this.orderPayStatus = orderPayStatus;
    }

    /**
     * 这里没有加上这个构造函数，Mybatis传递到实体类时会用上面那个
     */
    public OrderPay(Integer id, Long orderPayId, Long orderId, Integer orderPayPlatform, String orderPayNumber, BigDecimal orderAmount, String orderPayStatus, Date createTime, Date updateTime, Date deleteTime) {
        this.id = id;
        this.orderPayId = orderPayId;
        this.orderId = orderId;
        this.orderPayPlatform = orderPayPlatform;
        this.orderPayNumber = orderPayNumber;
        this.orderAmount = orderAmount;
        this.orderPayStatus = orderPayStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
    }
}