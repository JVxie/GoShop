package com.jvxie.goshop.model;

import java.util.Date;

public class Shipping {
    private Integer id;

    private String shippingId;

    private String shippingName;

    private Integer shippingPhone;

    private String shippingProvince;

    private String shippingCity;

    private String shippingDistrct;

    private String shippingAddress;

    private Integer shippingZip;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId == null ? null : shippingId.trim();
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public Integer getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(Integer shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingProvince() {
        return shippingProvince;
    }

    public void setShippingProvince(String shippingProvince) {
        this.shippingProvince = shippingProvince == null ? null : shippingProvince.trim();
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity == null ? null : shippingCity.trim();
    }

    public String getShippingDistrct() {
        return shippingDistrct;
    }

    public void setShippingDistrct(String shippingDistrct) {
        this.shippingDistrct = shippingDistrct == null ? null : shippingDistrct.trim();
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
    }

    public Integer getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(Integer shippingZip) {
        this.shippingZip = shippingZip;
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