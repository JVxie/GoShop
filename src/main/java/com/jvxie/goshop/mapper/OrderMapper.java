package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.Order;

import java.util.List;

/**
 * 插入order表 order需要加反引号
 * `order`
 */

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByUserId(Long userId);

    Order selectByOrderId(Long orderId);

    int updateByOrderId(Order record);
}