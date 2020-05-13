package com.jvxie.goshop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * goods_type
 * @author 
 */
@Data
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
}