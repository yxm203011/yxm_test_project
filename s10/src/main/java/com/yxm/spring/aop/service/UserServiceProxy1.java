package com.yxm.spring.aop.service;

public class UserServiceProxy1 implements UserService{

    private UserService userService;

    public UserServiceProxy1(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
        userService.createUser();
        System.out.println("======后置=====");
    }
}
