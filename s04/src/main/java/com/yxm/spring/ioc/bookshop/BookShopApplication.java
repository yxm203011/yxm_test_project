package com.yxm.spring.ioc.bookshop;

import com.yxm.spring.ioc.bookshop.entity.Company;
import com.yxm.spring.ioc.bookshop.entity.Computer;
import com.yxm.spring.ioc.bookshop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-Comany.xml");
        Computer computer = context.getBean("computer", Computer.class);
        computer.insert("1");
    }
}
