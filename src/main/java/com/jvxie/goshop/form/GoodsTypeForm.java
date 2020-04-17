package com.jvxie.goshop.form;

import lombok.Data;
import lombok.Getter;

@Data
public class GoodsTypeForm {
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
}
