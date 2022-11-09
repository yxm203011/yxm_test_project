package com.yxm.spring.aop;

import com.yxm.spring.aop.context.ClassPathXmlApplicationContext;
import com.yxm.spring.aop.entity.Apple;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        Apple sweetApple = (Apple)classPathXmlApplicationContext.getBean("sweetApple");
        System.out.println(sweetApple.getTitle());
    }
}
