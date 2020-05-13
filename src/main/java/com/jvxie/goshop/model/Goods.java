package com.jvxie.goshop.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * goods
 * @author 
 */
@Data
public class Goods implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsTitle;

    /**
     * 商品类型ID，0：未分类
     */
    private Long goodsTypeId;

    /**
     * 商品原售价
     */
    private BigDecimal goodsOldPrice;

    /**
     * 商品现售价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品状态，0：已下架，1：上架，2：已删除
     */
    private Integer goodsStatus;

    /**
     * 商品库存
     */
    private Integer goodsCount;

    /**
     * 商品缩略图
     */
    private String goodsImg;

    /**
     * 商品详情
     */
    private String goodsDetail;

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