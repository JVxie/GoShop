package com.jvxie.goshop.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfoVo {
    /**
     * 订单详情所属订单ID
     */
    private String orderId;

    /**
     * 下单商品原ID
     */
    private String orignGoodsId;

    /**
     * 下单时商品名称
     */
    private String orignGoodsTitle;

    /**
     * 下单时商品图片
     */
    private String orignGoodsImg;

    /**
     * 下单时商品单价
     */
    private BigDecimal orignGoodsPrice;

    /**
     * 下单商品数量
     */
    private Integer orderQuantity;

    /**
     * 商品总价：数量*单价
     */
    private BigDecimal orderTotalPrice;

    /**
     * 创建时间
     */
    private Date createTime;
}
