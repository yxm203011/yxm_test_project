package factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
