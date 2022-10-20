package com.yxm.spring.ioc;

import com.yxm.spring.ioc.entity.Apple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        Apple apple2 = applicationContext.getBean("apple2", Apple.class);
        System.out.println(apple2.getTitle()+"价格："+apple2.getPrice());
    }
}
