package com.test.yxm.junit.spring;

import com.test.yxm.junit.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class springTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = application.getBean("userService",UserService.class);
        System.out.println(userService);
    }
}
