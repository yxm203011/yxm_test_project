package Beans.factory.support;


import Beans.BeansException;
import Beans.factory.BeanFactory;
import Beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName,null);
    }

    protected <T> T doGetBean(final String beanName,final Object[] args){
        Object bean = getSingleton(beanName);
        if(null != bean){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T)createBean(beanName,beanDefinition,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Beans.factory.BeansException {
        return (T) getBean(name);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName)throws BeansException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeansException;
}
