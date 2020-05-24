package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int batchInsert(@Param("orderInfoList") List<OrderInfo> orderInfoList);

    List<OrderInfo> selectByOrderIdSet(@Param("orderIdSet") Set<Long> orderIdSet);
}