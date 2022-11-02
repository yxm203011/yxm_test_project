package com.yxm.spring.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserOracleDao implements IUserDao{
    public UserOracleDao() {
        System.out.println("正在创建UserOracleDao");
    }
}
