package com.yxm.spring.aop;

import com.yxm.spring.aop.service.UserService;
import com.yxm.spring.aop.service.UserServiceImpl;
import com.yxm.spring.aop.service.UserServiceProxy;
import com.yxm.spring.aop.service.UserServiceProxy1;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceProxy1(new UserServiceProxy(new UserServiceImpl()));
        userService.createUser();
    }
}
