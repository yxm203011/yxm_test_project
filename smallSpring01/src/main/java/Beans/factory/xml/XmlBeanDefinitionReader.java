package Beans.factory.xml;


import Beans.PropertyValue;
import Beans.PropertyValues;
import Beans.factory.BeansException;
import Beans.factory.config.BeanDefinition;
import Beans.factory.config.BeanReference;
import Beans.factory.support.AbstractBeanDefinitionReader;
import Beans.factory.support.BeanDefinitionRegistry;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import core.io.Resource;
import core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        super(beanDefinitionRegistry);
    }

    @Override
    public void localBeanDefinitions(Resource resource) throws BeansException {
        try{
                try(InputStream inputStream = resource.getInputStream()){
                    doLocalBeanDefinitions(inputStream);
                }
        }catch (IOException | ClassNotFoundException e){
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void localBeanDefinitions(Resource... resource) throws BeansException {
        for (Resource resource1 : resource) {
            localBeanDefinitions(resource1);
        }
    }

    @Override
    public void localBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        localBeanDefinitions(resource);
    }

    protected void doLocalBeanDefinitions(InputStream inputStream) throws ClassNotFoundException{
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            // ????????????
            if (!(childNodes.item(i) instanceof Element)) continue;
            // ????????????
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // ????????????
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // ?????? Class??????????????????????????????
            Class<?> clazz = Class.forName(className);
            // ????????? id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // ??????Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // ?????????????????????
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                // ???????????????property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // ??????????????????????????????????????????
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // ??????????????????
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegister().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // ?????? BeanDefinition
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
