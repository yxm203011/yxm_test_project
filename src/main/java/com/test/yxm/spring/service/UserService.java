package com.test.yxm.spring.service;

import com.test.yxm.spring.entity.User;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService{ //implements BeanNameAware, InitializingBean {

    /*//在Spring自动注入式获取当前Bean的名字
    @Override
    public void setBeanName(String name) {
        this.beanName=name;
    }

    //可以实现InitializingBean来实现自定义
    @Override
    public void afterPropertiesSet() throws Exception {

    }*/



}
