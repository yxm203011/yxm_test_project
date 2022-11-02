package com.yxm.spring.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserOrcalDao implements IUserDao{
    public UserOrcalDao() {
        System.out.println("正在创建UserOrcalDao");
    }
}
