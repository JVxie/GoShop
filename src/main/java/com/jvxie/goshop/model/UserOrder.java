package com.jvxie.goshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * user_order
 * @author 
 */
public class UserOrder implements Serializable {
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
    private String userId;

    /**
     * 收货地址ID，0：虚拟物品
     */
    private String shippingId;

    /**
     * 订单创建时间
     */
    private Date orderTime;

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
     * 支付方式，1：支付宝，2：微信，3：银行卡
     */
    private Integer orderPayType;

    /**
     * 订单总金额
     */
    private BigDecimal orderAllCost;

    /**
     * 订单实付金额
     */
    private BigDecimal orderRealCost;

    /**
     * 订单减免金额
     */
    private BigDecimal orderDiscount;

    /**
     * 订单状态，1：待支付，2：待收货，3：待评价，4：已退款，5：已关闭，6：已完成
     */
    private Integer orderStatus;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public Date getOrderSendTime() {
        return orderSendTime;
    }

    public void setOrderSendTime(Date orderSendTime) {
        this.orderSendTime = orderSendTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public Date getOrderCloseTime() {
        return orderCloseTime;
    }

    public void setOrderCloseTime(Date orderCloseTime) {
        this.orderCloseTime = orderCloseTime;
    }

    public Integer getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(Integer orderPayType) {
        this.orderPayType = orderPayType;
    }

    public BigDecimal getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(BigDecimal orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public BigDecimal getOrderRealCost() {
        return orderRealCost;
    }

    public void setOrderRealCost(BigDecimal orderRealCost) {
        this.orderRealCost = orderRealCost;
    }

    public BigDecimal getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(BigDecimal orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserOrder other = (UserOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShippingId() == null ? other.getShippingId() == null : this.getShippingId().equals(other.getShippingId()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getOrderPayTime() == null ? other.getOrderPayTime() == null : this.getOrderPayTime().equals(other.getOrderPayTime()))
            && (this.getOrderSendTime() == null ? other.getOrderSendTime() == null : this.getOrderSendTime().equals(other.getOrderSendTime()))
            && (this.getOrderEndTime() == null ? other.getOrderEndTime() == null : this.getOrderEndTime().equals(other.getOrderEndTime()))
            && (this.getOrderCloseTime() == null ? other.getOrderCloseTime() == null : this.getOrderCloseTime().equals(other.getOrderCloseTime()))
            && (this.getOrderPayType() == null ? other.getOrderPayType() == null : this.getOrderPayType().equals(other.getOrderPayType()))
            && (this.getOrderAllCost() == null ? other.getOrderAllCost() == null : this.getOrderAllCost().equals(other.getOrderAllCost()))
            && (this.getOrderRealCost() == null ? other.getOrderRealCost() == null : this.getOrderRealCost().equals(other.getOrderRealCost()))
            && (this.getOrderDiscount() == null ? other.getOrderDiscount() == null : this.getOrderDiscount().equals(other.getOrderDiscount()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShippingId() == null) ? 0 : getShippingId().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getOrderPayTime() == null) ? 0 : getOrderPayTime().hashCode());
        result = prime * result + ((getOrderSendTime() == null) ? 0 : getOrderSendTime().hashCode());
        result = prime * result + ((getOrderEndTime() == null) ? 0 : getOrderEndTime().hashCode());
        result = prime * result + ((getOrderCloseTime() == null) ? 0 : getOrderCloseTime().hashCode());
        result = prime * result + ((getOrderPayType() == null) ? 0 : getOrderPayType().hashCode());
        result = prime * result + ((getOrderAllCost() == null) ? 0 : getOrderAllCost().hashCode());
        result = prime * result + ((getOrderRealCost() == null) ? 0 : getOrderRealCost().hashCode());
        result = prime * result + ((getOrderDiscount() == null) ? 0 : getOrderDiscount().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", shippingId=").append(shippingId);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", orderPayTime=").append(orderPayTime);
        sb.append(", orderSendTime=").append(orderSendTime);
        sb.append(", orderEndTime=").append(orderEndTime);
        sb.append(", orderCloseTime=").append(orderCloseTime);
        sb.append(", orderPayType=").append(orderPayType);
        sb.append(", orderAllCost=").append(orderAllCost);
        sb.append(", orderRealCost=").append(orderRealCost);
        sb.append(", orderDiscount=").append(orderDiscount);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}