package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.UserOrderInfo;

public interface UserOrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOrderInfo record);

    int insertSelective(UserOrderInfo record);

    UserOrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOrderInfo record);

    int updateByPrimaryKey(UserOrderInfo record);
}