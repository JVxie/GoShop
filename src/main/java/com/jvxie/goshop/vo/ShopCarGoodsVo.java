package com.jvxie.goshop.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShopCarGoodsVo {
    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品购买数量
     */
    private Integer quantity;

    /**
     * 商品名称
     */
    private String goodsTitle;

    /**
     * 商品缩略图
     */
    private String goodsImg;

    /**
     * 商品现售价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品状态，0：已下架，1：上架，2：已删除
     */
    private Integer goodsStatus;

    /**
     * 商品总价 = 单价 * 数量
     */
    private BigDecimal goodsTotalPrice;

    /**
     * 商品库存
     */
    private Integer goodsCount;

    /**
     * 是否选择
     */
    private Boolean selected;

    public ShopCarGoodsVo(Long goodsId, Integer quantity, String goodsTitle, String goodsImg, BigDecimal goodsPrice, Integer goodsStatus, BigDecimal goodsTotalPrice, Integer goodsCount, Boolean selected) {
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.goodsTitle = goodsTitle;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.goodsStatus = goodsStatus;
        this.goodsTotalPrice = goodsTotalPrice;
        this.goodsCount = goodsCount;
        this.selected = selected;
    }
}
