package com.yxm.spring.aop;

import com.yxm.spring.aop.entity.Apple;
import com.yxm.spring.aop.entity.Chlid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        Apple sweetApple = applicationContext.getBean("sweetApple",Apple.class);
        System.out.println(sweetApple.getTitle());
        Chlid child1 = applicationContext.getBean("child1", Chlid.class);
        child1.eat();
        Chlid child2 = applicationContext.getBean("child2", Chlid.class);
        child2.eat();
        Chlid child3 = applicationContext.getBean("child3", Chlid.class);
        child3.eat();
    }
}
