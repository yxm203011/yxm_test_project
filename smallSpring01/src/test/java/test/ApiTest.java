package test;

import Beans.PropertyValue;
import Beans.PropertyValues;
import Beans.factory.config.BeanDefinition;
import Beans.factory.config.BeanReference;
import Beans.factory.support.DefaultListableBeanFactory;
import Beans.factory.xml.XmlBeanDefinitionReader;
import cn.hutool.core.io.IoUtil;
import core.io.DefaultResourceLoader;
import core.io.Resource;
import org.junit.Before;
import org.junit.Test;
import test.bean.UserDao;
import test.bean.UserService;

import java.io.InputStream;


/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }

    private DefaultResourceLoader defaultResourceLoader;

    @Before
    public void init(){
        defaultResourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test1() throws Exception{
        Resource resource = defaultResourceLoader.getResource("classPath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void test2() throws Exception{
        Resource resource = defaultResourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void test3() throws Exception{
        Resource resource = defaultResourceLoader.getResource("https://github.com/yxm203011/UsedCar/blob/master/ideaworkspaces/UsedCar/src/main/resources/application.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void test4(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        reader.localBeanDefinitions("classPath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = defaultListableBeanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }



}
