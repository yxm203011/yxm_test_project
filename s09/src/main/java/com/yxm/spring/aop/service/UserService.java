package com.yxm.spring.aop.service;


import com.yxm.spring.aop.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public void createUser(){
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("执行员工入职逻辑");
        userDao.insert();
    }

}
