package com.yxm.spring.ioc;

import com.yxm.spring.ioc.context.ClassPathXmlApplicationContext;
import com.yxm.spring.ioc.entity.Apple;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        Apple sweetApple = (Apple)classPathXmlApplicationContext.getBean("sweetApple");
        System.out.println(sweetApple.getTitle());
    }
}
