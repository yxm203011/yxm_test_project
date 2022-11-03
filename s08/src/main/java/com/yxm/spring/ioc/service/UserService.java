package com.yxm.spring.ioc.service;

import com.yxm.spring.ioc.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void createUser(){
        System.out.println("调用业务代码");
        userDao.insert();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
