package com.yxm.spring.ioc;

import com.yxm.spring.ioc.entity.Apple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        Apple sweetApple = applicationContext.getBean("sweetApple", Apple.class);
        System.out.println(sweetApple.getTitle()+"价格："+sweetApple.getPrice());
    }
}
