package com.yxm.spring.aop.service;

public class UserServiceProxy implements UserService{

    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
        System.out.println("======当前时间======");
        userService.createUser();
    }
}
