package com.jvxie.goshop.model;

import java.util.Date;

public class GoodsType {
    private Integer id;

    private String goodsTypeId;

    private String parentTypeId;

    private Integer goodsTypeStatus;

    private Integer goodsTypeSort;

    private String typeIconClass;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(String goodsTypeId) {
        this.goodsTypeId = goodsTypeId == null ? null : goodsTypeId.trim();
    }

    public String getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId == null ? null : parentTypeId.trim();
    }

    public Integer getGoodsTypeStatus() {
        return goodsTypeStatus;
    }

    public void setGoodsTypeStatus(Integer goodsTypeStatus) {
        this.goodsTypeStatus = goodsTypeStatus;
    }

    public Integer getGoodsTypeSort() {
        return goodsTypeSort;
    }

    public void setGoodsTypeSort(Integer goodsTypeSort) {
        this.goodsTypeSort = goodsTypeSort;
    }

    public String getTypeIconClass() {
        return typeIconClass;
    }

    public void setTypeIconClass(String typeIconClass) {
        this.typeIconClass = typeIconClass == null ? null : typeIconClass.trim();
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