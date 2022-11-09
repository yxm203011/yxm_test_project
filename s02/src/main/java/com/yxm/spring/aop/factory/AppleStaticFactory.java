package com.yxm.spring.aop.factory;

import com.yxm.spring.aop.entity.Apple;

public class AppleStaticFactory {

    public static Apple createSweetApple(){
        Apple apple = new Apple();
        apple.setTitle("红富士");
        apple.setColor("红色");
        apple.setOrigin("欧洲");
        return apple;
    }

}
