package Beans.factory.support;


import Beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//JDK实例化
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz= beanDefinition.getBeanClass();
        try{
            //为不为空是判断是不是有构造函数
            //不为空是有构造函数则需要进行特殊处理
            if(ctor != null){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch(Exception e){

        }
        return null;
    }

}
