package com.jvxie.goshop.enums;

public enum IdGeneratorEnum {
    GOODS(0, 0),
    GOODS_TYPE(0, 1),
    SHIPPING(0, 2),
//    SHOP_CAR(0, 3), 废弃，已使用Redis方式储存，无需生成Id
    USER(0, 4),
    USER_GROUP(0, 5),
    ORDER(0, 6),
    ORDER_INFO(0, 7),
    ORDER_PAY(0, 8),
    TOKEN(0, 9),
    ;

    private long workerId;
    private long datacenterId;

    IdGeneratorEnum(long workerId, long datacenterId) {
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }
}
