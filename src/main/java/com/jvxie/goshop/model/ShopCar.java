package com.jvxie.goshop.model;

import java.util.Date;

public class ShopCar {
    private Integer id;

    private String shopCarId;

    private String userId;

    private String goodsId;

    private Integer shopCarCount;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopCarId() {
        return shopCarId;
    }

    public void setShopCarId(String shopCarId) {
        this.shopCarId = shopCarId == null ? null : shopCarId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getShopCarCount() {
        return shopCarCount;
    }

    public void setShopCarCount(Integer shopCarCount) {
        this.shopCarCount = shopCarCount;
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