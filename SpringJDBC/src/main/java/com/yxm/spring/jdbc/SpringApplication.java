package com.yxm.spring.jdbc;

import com.yxm.spring.jdbc.dao.EmployeeDao;
import com.yxm.spring.jdbc.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        Employee byId = employeeDao.findById(3308);
        System.out.println(byId);
    }
}
