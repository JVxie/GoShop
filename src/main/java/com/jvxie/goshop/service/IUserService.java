package com.jvxie.goshop.service;

import com.jvxie.goshop.model.User;
import com.jvxie.goshop.vo.ResponseVo;

public interface IUserService {

    /**
     * 注册功能
     * 1、透过邮箱
     * 2、透过手机号码
     */
    ResponseVo registerByEmail(User user);
    ResponseVo registerByPhone(User user);

    /**
     * 登录功能
     */
    ResponseVo loginByEmail(String userEmail, String userPsw);
    ResponseVo loginByPhone(String userPhone, String userPsw);
}
