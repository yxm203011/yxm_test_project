package com.yxm.spring.aop;

import com.yxm.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.createUser();
    }
}
