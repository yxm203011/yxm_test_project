package com.yxm.spring.aop.service;

import com.yxm.spring.aop.dao.IUserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope
public class UserService {

    @Value("${metaDate}")
    private String metaDate;

    public UserService() {
        System.out.println("正在创建UserService");
    }

    //@Autowired
    private IUserDao udao;

    @PostConstruct //XML中的bean init-method方法完全相同 创建完bean对象后会调用这个方法
    public void init(){
        System.out.println("初始化init方法"+metaDate);
    }


}
