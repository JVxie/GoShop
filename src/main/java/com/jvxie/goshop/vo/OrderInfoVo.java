package com.jvxie.goshop.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
public class OrderInfoVo {
    /**
     * 订单详情所属订单ID
     */
    private Long orderId;

    /**
     * 下单商品原ID
     */
    private Long goodsId;

    /**
     * 下单时商品名称
     */
    private String goodsTitle;

    /**
     * 下单时商品图片
     */
    private String goodsImg;

    /**
     * 下单时商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 下单商品数量
     */
    private Integer quantity;

    /**
     * 商品总价：数量*单价
     */
    private BigDecimal totalPrice;

    /**
     * 创建时间
     */
    private Date createTime;
}
