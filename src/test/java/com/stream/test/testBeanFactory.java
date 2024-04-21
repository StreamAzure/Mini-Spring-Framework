package com.stream.test;

import com.stream.minispring.BeanDefinition;
import com.stream.minispring.BeanFactory;
import org.junit.jupiter.api.Test;

public class testBeanFactory {
    @Test
    public void test_BeanFactory(){
        BeanFactory beanFactory = new BeanFactory();

        // 注册 Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
