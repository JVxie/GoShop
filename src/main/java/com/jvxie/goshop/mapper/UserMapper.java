package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int countByUserEmail(String userEmail);

    int countByUserPhone(String userPhone);

    User selectByUserEmail(String userEmail);

    User selectByUserPhone(String userPhone);
}