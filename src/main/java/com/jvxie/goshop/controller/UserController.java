package com.jvxie.goshop.controller;

import com.jvxie.goshop.constants.CookieConstants;
import com.jvxie.goshop.constants.RedisConstants;
import com.jvxie.goshop.enums.IdGeneratorEnum;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.form.UserByEmailForm;
import com.jvxie.goshop.form.UserByPhoneForm;
import com.jvxie.goshop.form.UserLoginFrom;
import com.jvxie.goshop.model.User;
import com.jvxie.goshop.service.impl.UserServiceImpl;
import com.jvxie.goshop.utils.CookieUtil;
import com.jvxie.goshop.utils.IdGeneratorUtil;
import com.jvxie.goshop.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.concurrent.TimeUnit;

import static com.jvxie.goshop.constants.GoShopConstants.*;
import static com.jvxie.goshop.enums.ResponseEnum.PARAM_ERROR;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/user/register")
    private String register() {
        return "register";
    }

    @PostMapping("/user/register/registerByPhone")
    private ResponseVo registerByPhone(@Valid @RequestBody UserByPhoneForm userByPhoneForm,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
//        log.info(userByPhoneForm.toString());
        User user = new User();
        BeanUtils.copyProperties(userByPhoneForm, user);
        return userService.registerByPhone(user);
    }

    @PostMapping("/user/register/registerByEmail")
    private ResponseVo registerByEmail(@Valid @RequestBody UserByEmailForm userByEmailForm,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
//        log.info(userByPhoneForm.toString());
        User user = new User();
        BeanUtils.copyProperties(userByEmailForm, user);
        return userService.registerByEmail(user);
    }

    @GetMapping("/user/login")
    private String login() {
        return "login";
    }

    @PostMapping("/user/login")
    private ResponseVo login(@Valid @RequestBody UserLoginFrom userLoginFrom,
                             BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        ResponseVo ret = ResponseVo.error(ResponseEnum.LOGINNAME_OR_PASSWORD_ERROR);;
        if (userLoginFrom.getLoginName().matches(PHONE_REGEXP)) {
            // 登录名是手机号码
            ret = userService.loginByPhone(userLoginFrom.getLoginName(), userLoginFrom.getUserPsw());
        } else if (userLoginFrom.getLoginName().matches(EMAIL_REGEXP)) {
            // 登录名是Email
            ret = userService.loginByEmail(userLoginFrom.getLoginName(), userLoginFrom.getUserPsw());
        }
        if (ret.getStatus().equals(SUCCESS_CODE)) {
            // 登录成功
//            session.setAttribute(CUSTOMER, ret.getData());
            IdGeneratorUtil idGeneratorUtil = new IdGeneratorUtil(IdGeneratorEnum.TOKEN);
            User user = (User)ret.getData();
            // 生成TokenId
            String tokenId = String.format("%s", idGeneratorUtil.nextId());
            // 放入Redis中
            redisTemplate.opsForValue().set(
                    String.format(RedisConstants.TOKEN_PREFIX, tokenId),
                    user.getUserId().toString(),
                    RedisConstants.TOKEN_EXPIRE,
                    TimeUnit.SECONDS
            );
            // token放入cookies中
            CookieUtil.set(response, "token", tokenId, RedisConstants.TOKEN_EXPIRE);
        } else {
            // 登录失败
            ret = ResponseVo.error(ResponseEnum.LOGINNAME_OR_PASSWORD_ERROR);
        }
        return ret;
    }

    @GetMapping("/user")
    private ResponseVo user(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        String userId = redisTemplate.opsForValue().get(String.format(RedisConstants.TOKEN_PREFIX, cookie.getValue()));
         log.info("userId = {}", Long.valueOf(userId));

        ResponseVo ret = userService.findByUserId(Long.valueOf(userId));
        return ret;
    }

    @GetMapping("/user/logout")
    private ResponseVo logout(HttpSession session) {
        User user = (User) session.getAttribute(CUSTOMER);
        session.removeAttribute(CUSTOMER);
        return ResponseVo.success();
    }
}
