package com.jvxie.goshop.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ShopCarAddForm {
    @NotNull(message = "商品id不能为空")
    private Long goodsId;

    private Boolean selected = true;

    @Max(value = 999, message = "商品单次最大只能添加999件")
    @Min(value = 1, message = "商品添加数量至少要1件")
    private Integer quantity;
}
