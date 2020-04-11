package com.jvxie.goshop.model;

import java.io.Serializable;
import java.util.Date;

/**
 * goods_type
 * @author 
 */
public class GoodsType implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 商品类型ID，0：未分类
     */
    private Long goodsTypeId;

    /**
     * 商品父类ID
     */
    private Long parentTypeId;

    /**
     * 商品类型名称
     */
    private String goodsTypeName;

    /**
     * 状态，0：关闭，1：开启
     */
    private Integer goodsTypeStatus;

    /**
     * 同类顺序
     */
    private Integer goodsTypeSort;

    /**
     * 商品类型图标
     */
    private String typeIconClass;

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

    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Long getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(Long parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
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
        this.typeIconClass = typeIconClass;
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
        GoodsType other = (GoodsType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsTypeId() == null ? other.getGoodsTypeId() == null : this.getGoodsTypeId().equals(other.getGoodsTypeId()))
            && (this.getParentTypeId() == null ? other.getParentTypeId() == null : this.getParentTypeId().equals(other.getParentTypeId()))
            && (this.getGoodsTypeName() == null ? other.getGoodsTypeName() == null : this.getGoodsTypeName().equals(other.getGoodsTypeName()))
            && (this.getGoodsTypeStatus() == null ? other.getGoodsTypeStatus() == null : this.getGoodsTypeStatus().equals(other.getGoodsTypeStatus()))
            && (this.getGoodsTypeSort() == null ? other.getGoodsTypeSort() == null : this.getGoodsTypeSort().equals(other.getGoodsTypeSort()))
            && (this.getTypeIconClass() == null ? other.getTypeIconClass() == null : this.getTypeIconClass().equals(other.getTypeIconClass()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsTypeId() == null) ? 0 : getGoodsTypeId().hashCode());
        result = prime * result + ((getParentTypeId() == null) ? 0 : getParentTypeId().hashCode());
        result = prime * result + ((getGoodsTypeName() == null) ? 0 : getGoodsTypeName().hashCode());
        result = prime * result + ((getGoodsTypeStatus() == null) ? 0 : getGoodsTypeStatus().hashCode());
        result = prime * result + ((getGoodsTypeSort() == null) ? 0 : getGoodsTypeSort().hashCode());
        result = prime * result + ((getTypeIconClass() == null) ? 0 : getTypeIconClass().hashCode());
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
        sb.append(", goodsTypeId=").append(goodsTypeId);
        sb.append(", parentTypeId=").append(parentTypeId);
        sb.append(", goodsTypeName=").append(goodsTypeName);
        sb.append(", goodsTypeStatus=").append(goodsTypeStatus);
        sb.append(", goodsTypeSort=").append(goodsTypeSort);
        sb.append(", typeIconClass=").append(typeIconClass);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}