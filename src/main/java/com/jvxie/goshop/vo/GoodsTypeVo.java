package com.jvxie.goshop.vo;

import lombok.Data;

import java.util.List;

@Data
public class GoodsTypeVo {
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
     * 子类目
     */
    private List<GoodsTypeVo> subGoodsType;
}
