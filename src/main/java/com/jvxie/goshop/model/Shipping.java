package com.jvxie.goshop.model;

import java.io.Serializable;
import java.util.Date;

/**
 * shipping
 * @author 
 */
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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingProvince() {
        return shippingProvince;
    }

    public void setShippingProvince(String shippingProvince) {
        this.shippingProvince = shippingProvince;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingDistrict() {
        return shippingDistrict;
    }

    public void setShippingDistrict(String shippingDistrict) {
        this.shippingDistrict = shippingDistrict;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(String shippingZip) {
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
        Shipping other = (Shipping) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShippingId() == null ? other.getShippingId() == null : this.getShippingId().equals(other.getShippingId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShippingName() == null ? other.getShippingName() == null : this.getShippingName().equals(other.getShippingName()))
            && (this.getShippingPhone() == null ? other.getShippingPhone() == null : this.getShippingPhone().equals(other.getShippingPhone()))
            && (this.getShippingProvince() == null ? other.getShippingProvince() == null : this.getShippingProvince().equals(other.getShippingProvince()))
            && (this.getShippingCity() == null ? other.getShippingCity() == null : this.getShippingCity().equals(other.getShippingCity()))
            && (this.getShippingDistrict() == null ? other.getShippingDistrict() == null : this.getShippingDistrict().equals(other.getShippingDistrict()))
            && (this.getShippingAddress() == null ? other.getShippingAddress() == null : this.getShippingAddress().equals(other.getShippingAddress()))
            && (this.getShippingZip() == null ? other.getShippingZip() == null : this.getShippingZip().equals(other.getShippingZip()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShippingId() == null) ? 0 : getShippingId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShippingName() == null) ? 0 : getShippingName().hashCode());
        result = prime * result + ((getShippingPhone() == null) ? 0 : getShippingPhone().hashCode());
        result = prime * result + ((getShippingProvince() == null) ? 0 : getShippingProvince().hashCode());
        result = prime * result + ((getShippingCity() == null) ? 0 : getShippingCity().hashCode());
        result = prime * result + ((getShippingDistrict() == null) ? 0 : getShippingDistrict().hashCode());
        result = prime * result + ((getShippingAddress() == null) ? 0 : getShippingAddress().hashCode());
        result = prime * result + ((getShippingZip() == null) ? 0 : getShippingZip().hashCode());
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
        sb.append(", shippingId=").append(shippingId);
        sb.append(", userId=").append(userId);
        sb.append(", shippingName=").append(shippingName);
        sb.append(", shippingPhone=").append(shippingPhone);
        sb.append(", shippingProvince=").append(shippingProvince);
        sb.append(", shippingCity=").append(shippingCity);
        sb.append(", shippingDistrict=").append(shippingDistrict);
        sb.append(", shippingAddress=").append(shippingAddress);
        sb.append(", shippingZip=").append(shippingZip);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}