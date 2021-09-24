package Beans.factory.support;

import Beans.factory.BeansException;
import core.io.Resource;
import core.io.ResourceLoader;

import java.io.IOException;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegister();

    ResourceLoader getResourceLoader();

    void localBeanDefinitions(Resource resource) throws BeansException;

    void localBeanDefinitions(Resource... resource) throws BeansException;

    void localBeanDefinitions(String location) throws BeansException;

}
