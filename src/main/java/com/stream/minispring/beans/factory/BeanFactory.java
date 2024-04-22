package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.BeanDefinition;

public interface BeanFactory {
    Object getBean(String name) throws Exception;
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
