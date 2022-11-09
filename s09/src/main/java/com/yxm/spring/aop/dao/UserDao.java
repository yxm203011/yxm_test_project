package com.yxm.spring.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void insert(){
        System.out.println("员工入职");
    }
}
