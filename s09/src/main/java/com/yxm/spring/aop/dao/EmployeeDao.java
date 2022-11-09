package com.yxm.spring.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    public void insert(){
        System.out.println("数据库添加员工");
    }
}
