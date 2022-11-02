package com.yxm.spring.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{

    public UserDao() {
        System.out.println("正在创建UserDao");
    }
}
