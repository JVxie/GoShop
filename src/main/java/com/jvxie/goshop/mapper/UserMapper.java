package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    int countByUserEmail(String userEmail);

    int countByUserPhone(String userPhone);

    User selectByUserEmail(String userEmail);

    User selectByUserPhone(String userPhone);

    User selectByUserId(Long userId);
}