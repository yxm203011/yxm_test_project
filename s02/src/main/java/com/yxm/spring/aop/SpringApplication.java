package com.yxm.spring.aop;

import com.yxm.spring.aop.entity.Apple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        String[] config = new String[]{"classpath:ApplicationContext.xml","classpath:ApplicationContext-1.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        Apple apple2 = applicationContext.getBean("apple7", Apple.class);
        System.out.println(apple2.getTitle()+"价格："+apple2.getPrice());

        Apple apple3 = applicationContext.getBean("com.yxm.spring.ioc.entity.Apple", Apple.class);
        System.out.println(apple3.getTitle()+"价格："+apple3.getPrice());
    }
}
