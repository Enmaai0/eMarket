package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.enums.RoleEnum;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class UserServiceImplTest extends EmarketApplicationTests {
    public static final String USERNAME = "me";
    public static final String PASSWORD = "123456";
    public static final String EMAIL = "me@gmail.com";
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void register() {
        User user = new User(USERNAME, PASSWORD, EMAIL, RoleEnum.Customer.getCode());
        ResponseVo<User> response = userService.register(user);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), response.getStatus());
    }

    @Test
    public void login() {
        register();
        ResponseVo<User> response = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), response.getStatus());

        response = userService.login(USERNAME, "wrong password");
        Assert.assertNotEquals(ResponseEnum.SUCCESS.getCode(), response.getStatus());
    }

}