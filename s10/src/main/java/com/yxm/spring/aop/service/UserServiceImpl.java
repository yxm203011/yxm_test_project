package com.yxm.spring.aop.service;

public class UserServiceImpl implements UserService{
    @Override
    public void createUser() {
        System.out.println("执行创建用户的业务逻辑");
    }
}
