package com.jvxie.goshop.controller;

import com.jvxie.goshop.form.UserByEmailForm;
import com.jvxie.goshop.form.UserByPhoneForm;
import com.jvxie.goshop.model.User;
import com.jvxie.goshop.service.impl.UserServiceImpl;
import com.jvxie.goshop.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.jvxie.goshop.enums.ResponseEnum.PARAM_ERROR;
import static com.jvxie.goshop.enums.ResponseEnum.PASS_ERROR;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/register")
    private String register() {
        return "register";
    }

    @PostMapping("/registerByPhone")
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

    @PostMapping("/registerByEmail")
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

    @RequestMapping("/login")
    private String login() {
        return "login";
    }

    @PostMapping("/loginByPhone")
    private ResponseVo loginByPhone(@Valid @RequestBody UserByPhoneForm userByPhoneForm,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.loginByPhone(userByPhoneForm.getUserPhone(), userByPhoneForm.getUserPsw());
    }

    @PostMapping("/loginByEmail")
    private ResponseVo loginByEmail(@Valid @RequestBody UserByEmailForm userByEmailForm,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.loginByEmail(userByEmailForm.getUserEmail(), userByEmailForm.getUserPsw());
    }
}
