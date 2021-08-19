package com.test.yxm.junit.spring.service;

import com.test.yxm.junit.spring.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanFactoryPostPrcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition userService = beanFactory.getBeanDefinition("userService");
        System.out.println(userService.getBeanClassName());
        userService.setBeanClassName(User.class.getName());
    }
}
