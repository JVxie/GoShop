package com.jvxie.goshop.model;

import lombok.Data;

@Data
public class ShopCar {
    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品购买数量
     */
    private Integer quantity;

    private Boolean selected;

    public ShopCar() {}

    public ShopCar(Long goodsId, Integer quantity, Boolean selected) {
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.selected = selected;
    }
}