package factory.support;


import factory.BeanFactory;
import factory.BeansException;
import factory.config.BeanDefinition;

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
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName)throws BeansException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeansException;
}
