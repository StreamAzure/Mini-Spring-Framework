package com.stream.minispring.beans;

/**
 * 一个 BeanDefinitionReader 需要实现的方法
 * loadBeanDefinitions
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
