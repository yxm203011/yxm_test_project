package com.yxm.spring.aop.service;

import com.yxm.spring.aop.dao.IUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentService {

    @Resource
    private IUserDao userDao;

    public void thisType(){
        System.out.println(userDao);
    }
}
