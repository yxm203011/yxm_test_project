package factory;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;
}
