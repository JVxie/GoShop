package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.enums.IdGeneratorEnum;
import com.jvxie.goshop.enums.UserGroupEnum;
import com.jvxie.goshop.mapper.UserMapper;
import com.jvxie.goshop.model.User;
import com.jvxie.goshop.plugin.IdGenerator;
import com.jvxie.goshop.service.IUserService;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.jvxie.goshop.enums.ResponseEnum.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVo registerByEmail(User user) {
        // 生成user_id
        IdGenerator idGenerator = new IdGenerator(IdGeneratorEnum.USER);
        user.setUserId(idGenerator.nextId());

        // 校验user_name是否为空
        if (user.getUserName() == null || user.getUserName().equals("")) {
            user.setUserName("用户" + user.getUserId());
        }

        // 校验邮箱
        if (userMapper.countByUserEmail(user.getUserEmail()) > 0) {
            return ResponseVo.error(USER_EMAIL_EXIST);
        }

        // MD5加密用户密码
        user.setUserPsw(DigestUtils.md5DigestAsHex(user.getUserPsw().getBytes(StandardCharsets.UTF_8)));

        // 默认注册用户为1：
        user.setUserGroupId(UserGroupEnum.CUSTOMER.getCode());

        // 写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ResponseVo.error(ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo registerByPhone(User user) {
        // 生成user_id
        IdGenerator idGenerator = new IdGenerator(IdGeneratorEnum.USER);
        user.setUserId(idGenerator.nextId());

        // 校验user_name
        if (user.getUserName() == null || user.getUserName().equals("")) {
            user.setUserName("用户" + user.getUserId());
        }

        // 校验手机号
        if (userMapper.countByUserPhone(user.getUserPhone()) > 0) {
            return ResponseVo.error(USER_PHONE_EXIST);
        }

        // MD5加密用户密码
        user.setUserPsw(DigestUtils.md5DigestAsHex(user.getUserPsw().getBytes(StandardCharsets.UTF_8)));

        // 默认注册用户为1：
        user.setUserGroupId(UserGroupEnum.CUSTOMER.getCode());

        // 写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ResponseVo.error(ERROR);
        }
        return ResponseVo.success();
    }

}
