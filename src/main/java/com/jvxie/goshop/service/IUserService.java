package com.jvxie.goshop.service;

import com.jvxie.goshop.form.UserByEmailForm;
import com.jvxie.goshop.form.UserByPhoneForm;
import com.jvxie.goshop.model.User;
import com.jvxie.goshop.vo.ResponseVo;

public interface IUserService {

    /**
     * 注册功能
     * 1、透过邮箱
     * 2、透过手机号码
     */
    ResponseVo<User> registerByEmail(UserByEmailForm form);
    ResponseVo<User> registerByPhone(UserByPhoneForm form);

    /**
     * 登录功能
     */
    ResponseVo<User> loginByEmail(String userEmail, String userPsw);
    ResponseVo<User> loginByPhone(String userPhone, String userPsw);

    /**
     * 搜索功能
     */
    ResponseVo<User> findByUserId(Long userId);

    /**
     * TODO 更新用户信息功能
     */
}
