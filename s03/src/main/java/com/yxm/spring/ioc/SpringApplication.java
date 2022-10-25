package com.yxm.spring.ioc;

import com.yxm.spring.ioc.entity.Apple;
import com.yxm.spring.ioc.entity.Chlid;
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
