package com.yxm.spring.aop;

import com.yxm.spring.aop.controller.UserController;
import com.yxm.spring.aop.dao.EmployeeDao;
import com.yxm.spring.aop.dao.UserDao;
import com.yxm.spring.aop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yxm")
public class Config {
    @Bean
    public UserDao userDao(){
        UserDao userDao= new UserDao();
        System.out.println("userDao已经创建"+userDao);
        return userDao;
    }
    @Bean
    public UserService userService(UserDao userDao, EmployeeDao employeeDao){
        UserService userService = new UserService();
        System.out.println("userService创建userDao"+userDao);
        System.out.println("userService已经创建"+userService);
        userService.setUserDao(userDao);
        userService.setEmployeeDao(employeeDao);
        return userService;
    }

    @Bean
    public UserController userController(UserService userService){
        System.out.println("userController已经创建"+userService);
        UserController userController = new UserController();
        userController.setUserService(userService);
        return userController;
    }

}
