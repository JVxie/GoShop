package com.jvxie.goshop.vo;

import com.jvxie.goshop.model.ShopCar;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ShopCarVo {
    private List<ShopCarGoodsVo> shopCarGoodsVoList;

    private Boolean selectAll;

    private BigDecimal shopCarTotalPrice;

    private Integer shopCarTotalQuantity;
}
