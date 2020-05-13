package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@Transactional
public class UserServiceImplTest extends GoshopApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void register() {
        User user = new User();
        userService.registerByPhone(user);
    }
}