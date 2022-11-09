package com.yxm.spring.aop;

import com.yxm.spring.aop.entity.Apple;
import com.yxm.spring.aop.entity.Chlid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        Chlid child = applicationContext.getBean("name3", Chlid.class);
        List<Apple> appleList = child.getAppleList();
        for (Apple apple : appleList) {
            System.out.println(child.getName() +"吃到了："+apple.getTitle());
        }
    }
}
