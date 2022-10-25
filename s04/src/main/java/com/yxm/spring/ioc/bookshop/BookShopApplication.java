package com.yxm.spring.ioc.bookshop;

import com.yxm.spring.ioc.bookshop.entity.Company;
import com.yxm.spring.ioc.bookshop.entity.Computer;
import com.yxm.spring.ioc.bookshop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.purchase();

        Company company = context.getBean("company", Company.class);
        String name = company.getInfo().getProperty("name");
        System.out.println(company.toString()+"name:"+name);
        System.out.println("-------------------");
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("类型:"+bean.getClass().getName());
            System.out.println("内容:"+bean);
        }

        System.out.println("------------------");
        Computer bean = context.getBean("com.yxm.spring.ioc.bookshop.entity.Computer#0", Computer.class);
        System.out.println(bean.getBrand());
    }
}
