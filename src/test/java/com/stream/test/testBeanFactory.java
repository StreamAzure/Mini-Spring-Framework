package com.stream.test;

import com.stream.minispring.beans.BeanDefinition;
import com.stream.minispring.beans.factory.AutowireCapableBeanFactory;
import com.stream.minispring.beans.factory.BeanFactory;
import org.junit.jupiter.api.Test;

public class testBeanFactory {
    @Test
    public void test() {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.stream.test.UserService"); // 获取类对象
        beanFactory.registerBeanDefinition("UserService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();

    }
}
