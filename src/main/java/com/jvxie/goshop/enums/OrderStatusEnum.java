package com.jvxie.goshop.enums;

import lombok.Getter;

/**
 * 订单状态，0：已取消，1：待支付，2：待发货，3：待收货，4：待评价，5：已退款，6：已关闭，7：已完成
 */

@Getter
public enum OrderStatusEnum {
    CANCELED(0, "已取消"),
    NO_PAY(1, "待支付"),
    NO_SHIP(2, "待发货"),
    SHIPPED(3, "待收货"),
    // 暂时不做评价、退款系统，这里待处理
    NO_COMMENT(4, "待评价"),
    REFUNDED(5, "已退款"),
    ORDER_CLOSED(6, "已关闭"),
    ORDER_SUCCESS(7, "已完成"),
    ;

    Integer code;

    String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
