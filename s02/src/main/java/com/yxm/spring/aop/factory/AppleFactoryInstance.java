package com.yxm.spring.aop.factory;

import com.yxm.spring.aop.entity.Apple;

//工厂实例方法创建对象是指IOC容器对工厂类进行实例化，并调用对应的实例方法创建对象的过程
public class AppleFactoryInstance {
    public Apple createSweetApple(){
        Apple apple = new Apple();
        apple.setTitle("红富士");
        apple.setColor("红色");
        apple.setOrigin("欧洲");
        return apple;
    }
}
