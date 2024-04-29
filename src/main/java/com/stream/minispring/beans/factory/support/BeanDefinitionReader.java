package com.stream.minispring.beans.factory.support;

import com.stream.minispring.beans.factory.support.BeanDefinitionRegistry;
import com.stream.minispring.io.Resource;
import com.stream.minispring.io.ResourceLoader;

/**
 * 一个 BeanDefinitionReader 需要实现的方法
 * loadBeanDefinitions
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(String location) throws Exception;
    void loadBeanDefinitions(Resource resource) throws Exception;
    void loadBeanDefinitions(String[] locations) throws Exception;
}
