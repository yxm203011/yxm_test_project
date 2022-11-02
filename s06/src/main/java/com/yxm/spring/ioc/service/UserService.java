package com.yxm.spring.ioc.service;

import com.yxm.spring.ioc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserService() {
        System.out.println("正在创建UserService");
    }

    @Autowired
    private IUserDao udao;
}
