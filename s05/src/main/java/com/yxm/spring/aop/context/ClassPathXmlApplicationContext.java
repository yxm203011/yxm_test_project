package com.yxm.spring.aop.context;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map iocContainer = new HashMap();

    public ClassPathXmlApplicationContext() {
        try {
            String filePath = this.getClass().getResource("/applicationContext.xml").getPath();
            filePath = new URLDecoder().decode(filePath, "UTF-8");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File(filePath));
            List<Node> beans = document.getRootElement().selectNodes("bean");
            for (Node node : beans) {
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Class c = Class.forName(className);
                Object object = c.newInstance();
                List<Node> propertys = element.selectNodes("property");
                for (Node p : propertys) {
                    Element property = (Element) p;
                    String propertyName = property.attributeValue("name");
                    String propertyValue = property.attributeValue("value");

                    String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                    System.out.println("准备执行"+setMethodName+"执行数据");
                    Method setMethod = c.getMethod(setMethodName, String.class);
                    setMethod.invoke(object,propertyValue);
                }
                iocContainer.put(id, object);
            }
            System.out.println("IOC初始化完毕！");
        } catch (Exception e) {

        }
    }

    @Override
    public Object getBean(String beanId) {
        return iocContainer.get(beanId);
    }

}
