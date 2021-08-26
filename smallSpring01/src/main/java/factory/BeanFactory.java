package factory;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName,Object... args) throws BeansException;

}
