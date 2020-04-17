package com.jvxie.goshop.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsVo {
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
}
