package com.jvxie.goshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order_info
 * @author 
 */
@Data
public class OrderInfo implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 订单详情ID
     */
    private Long orderInfoId;

    /**
     * 订单详情所属订单ID
     */
    private Long orderId;

    /**
     * 订单详情所属用户ID
     */
    private Long userId;

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

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    private static final long serialVersionUID = 1L;
}