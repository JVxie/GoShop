package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.UserOrderPay;

public interface UserOrderPayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOrderPay record);

    int insertSelective(UserOrderPay record);

    UserOrderPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOrderPay record);

    int updateByPrimaryKey(UserOrderPay record);
}