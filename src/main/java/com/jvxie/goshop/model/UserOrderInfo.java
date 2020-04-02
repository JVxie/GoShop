package com.jvxie.goshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * user_order_info
 * @author 
 */
public class UserOrderInfo implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 订单详情ID
     */
    private Long orderInfoId;

    /**
     * 订单详情所属订单ID
     */
    private String orderId;

    /**
     * 下单商品原ID
     */
    private String orignGoodsId;

    /**
     * 下单商品数量
     */
    private Integer orderCount;

    /**
     * 下单时商品单价
     */
    private BigDecimal orignGoodsPrice;

    /**
     * 下单时商品名称
     */
    private String orignGoodsTitle;

    /**
     * 下单时商品图片
     */
    private String orignGoodsImg;

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

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrignGoodsId() {
        return orignGoodsId;
    }

    public void setOrignGoodsId(String orignGoodsId) {
        this.orignGoodsId = orignGoodsId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getOrignGoodsPrice() {
        return orignGoodsPrice;
    }

    public void setOrignGoodsPrice(BigDecimal orignGoodsPrice) {
        this.orignGoodsPrice = orignGoodsPrice;
    }

    public String getOrignGoodsTitle() {
        return orignGoodsTitle;
    }

    public void setOrignGoodsTitle(String orignGoodsTitle) {
        this.orignGoodsTitle = orignGoodsTitle;
    }

    public String getOrignGoodsImg() {
        return orignGoodsImg;
    }

    public void setOrignGoodsImg(String orignGoodsImg) {
        this.orignGoodsImg = orignGoodsImg;
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
        UserOrderInfo other = (UserOrderInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderInfoId() == null ? other.getOrderInfoId() == null : this.getOrderInfoId().equals(other.getOrderInfoId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrignGoodsId() == null ? other.getOrignGoodsId() == null : this.getOrignGoodsId().equals(other.getOrignGoodsId()))
            && (this.getOrderCount() == null ? other.getOrderCount() == null : this.getOrderCount().equals(other.getOrderCount()))
            && (this.getOrignGoodsPrice() == null ? other.getOrignGoodsPrice() == null : this.getOrignGoodsPrice().equals(other.getOrignGoodsPrice()))
            && (this.getOrignGoodsTitle() == null ? other.getOrignGoodsTitle() == null : this.getOrignGoodsTitle().equals(other.getOrignGoodsTitle()))
            && (this.getOrignGoodsImg() == null ? other.getOrignGoodsImg() == null : this.getOrignGoodsImg().equals(other.getOrignGoodsImg()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderInfoId() == null) ? 0 : getOrderInfoId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrignGoodsId() == null) ? 0 : getOrignGoodsId().hashCode());
        result = prime * result + ((getOrderCount() == null) ? 0 : getOrderCount().hashCode());
        result = prime * result + ((getOrignGoodsPrice() == null) ? 0 : getOrignGoodsPrice().hashCode());
        result = prime * result + ((getOrignGoodsTitle() == null) ? 0 : getOrignGoodsTitle().hashCode());
        result = prime * result + ((getOrignGoodsImg() == null) ? 0 : getOrignGoodsImg().hashCode());
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
        sb.append(", orderInfoId=").append(orderInfoId);
        sb.append(", orderId=").append(orderId);
        sb.append(", orignGoodsId=").append(orignGoodsId);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", orignGoodsPrice=").append(orignGoodsPrice);
        sb.append(", orignGoodsTitle=").append(orignGoodsTitle);
        sb.append(", orignGoodsImg=").append(orignGoodsImg);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}