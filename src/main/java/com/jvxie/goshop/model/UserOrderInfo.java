package com.jvxie.goshop.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserOrderInfo {
    private Integer id;

    private String orderInfoId;

    private String orderId;

    private String orignGoodsId;

    private Integer orderCount;

    private BigDecimal orignGoodsPrice;

    private String orignGoodsTitle;

    private String orignGoodsImg;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(String orderInfoId) {
        this.orderInfoId = orderInfoId == null ? null : orderInfoId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrignGoodsId() {
        return orignGoodsId;
    }

    public void setOrignGoodsId(String orignGoodsId) {
        this.orignGoodsId = orignGoodsId == null ? null : orignGoodsId.trim();
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
        this.orignGoodsTitle = orignGoodsTitle == null ? null : orignGoodsTitle.trim();
    }

    public String getOrignGoodsImg() {
        return orignGoodsImg;
    }

    public void setOrignGoodsImg(String orignGoodsImg) {
        this.orignGoodsImg = orignGoodsImg == null ? null : orignGoodsImg.trim();
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
}