package com.yxm.spring.ioc;

import com.yxm.spring.ioc.service.DepartmentService;
import com.yxm.spring.ioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        DepartmentService departmentService = applicationContext.getBean("departmentService", DepartmentService.class);
        departmentService.thisType();
    }
}
