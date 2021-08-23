package factory.support;

import factory.BeansException;
import factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        }catch(InstantiationException | IllegalAccessException e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingletonObject(beanName,bean);
        return bean;
    }

}
