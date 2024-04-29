package com.stream.test.ioc;

import com.stream.minispring.beans.factory.support.DefaultListableBeanFactory;
import com.stream.minispring.beans.factory.xml.XMLBeanDefinitionReader;
import com.stream.test.ioc.service.UserService;
import org.junit.Test;


public class XmlFileDefineBeanTest {
    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XMLBeanDefinitionReader beanDefinitionReader = new XMLBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("C:\\Me\\Mini-Spring\\Mini-Spring-Framework\\src\\test\\resources\\test.xml"); // 读取XML配置

        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();
    }
}
