package com.yxm.spring.ioc.bookshop;

import com.yxm.spring.ioc.bookshop.entity.Company;
import com.yxm.spring.ioc.bookshop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.purchase();

        Company company = context.getBean("company", Company.class);
        String name = company.getInfo().getProperty("name");
        System.out.println(company.toString()+"name:"+name);
    }
}
