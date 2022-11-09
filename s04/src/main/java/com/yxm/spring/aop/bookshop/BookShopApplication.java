package com.yxm.spring.aop.bookshop;

import com.yxm.spring.aop.bookshop.entity.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-Comany.xml");
        Computer computer = context.getBean("computer", Computer.class);
        computer.insert("1");
    }
}
