package com.stream.test;

import com.stream.minispring.beans.factory.config.BeanDefinition;
import com.stream.minispring.beans.PropertyValue;
import com.stream.minispring.beans.PropertyValues;
import com.stream.minispring.beans.factory.support.DefaultListableBeanFactory;
import com.stream.test.ioc.service.UserService;
import org.junit.jupiter.api.Test;

public class testBeanFactory {
    @Test
    public void test() throws Exception {
        // 1.初始化beanfactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.BeanDefinition
        Class<?> cls = Class.forName("com.stream.test.ioc.service.UserServiceImpl");
        BeanDefinition beanDefinition = new BeanDefinition(cls);

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello, world"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.注册Bean
        beanFactory.registerBeanDefinition("UserService", beanDefinition);

        // 5.获取bean
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();
    }

//    @Test
//    public void testXML() throws Exception{
//        // 读取XML配置
//        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new DefaultResourceLoader());
//        xmlBeanDefinitionReader.loadBeanDefinitions("src/test/resources/test.xml");
//
//        // 初始化BeanFactory并注册Bean
//        BeanFactory beanFactory = new DefaultListableBeanFactory();
//        for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
//            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
//        }
//
//        // 获取bean
//        UserService userService = (UserService) beanFactory.getBean("UserService");
//        userService.queryUserInfo();
//    }
//
//
//    @Test
//    public void testContext() throws Exception{
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/test/resources/test.xml");
//        OutputService outputService = (OutputService) applicationContext.getBean("OutputService");
//        outputService.output();
//    }
}
