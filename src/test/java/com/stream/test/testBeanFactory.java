package com.stream.test;

import com.stream.minispring.beans.BeanDefinition;
import com.stream.minispring.beans.PropertyValue;
import com.stream.minispring.beans.PropertyValues;
import com.stream.minispring.beans.factory.AutowireCapableBeanFactory;
import com.stream.minispring.beans.factory.BeanFactory;
import com.stream.minispring.beans.io.ResourceLoader;
import com.stream.minispring.beans.xml.XMLBeanDefinitionReader;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class testBeanFactory {
    @Test
    public void test() throws Exception {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.Bean 定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.stream.test.UserService"); // 获取类对象

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

    @Test
    public void testXML() throws Exception{
        // 读取XML配置
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("test.xml");

        // 初始化BeanFactory并注册Bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();
    }
}
