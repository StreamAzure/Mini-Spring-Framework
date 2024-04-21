package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.BeanDefinition;

public interface BeanFactory {
    Object getBean(String name);
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
