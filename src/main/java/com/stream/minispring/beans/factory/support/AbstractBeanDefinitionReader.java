package com.stream.minispring.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import com.stream.minispring.beans.factory.config.BeanDefinition;
import com.stream.minispring.beans.factory.support.BeanDefinitionReader;
import com.stream.minispring.io.DefaultResourceLoader;
import com.stream.minispring.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 从资源中读取BeanDefinition，并向容器中注册BeanDefinition
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
        // resourceLoader 默认为 DefaultResourceLoader
        this(registry, new DefaultResourceLoader());
    }
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader){
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }
    @Override
    public void loadBeanDefinitions(String[] locations) throws Exception{
        for(String location : locations){
            loadBeanDefinitions(location);
        }
    }

    public void setResourceLoader(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry(){
        return this.registry;
    }
    @Override
    public ResourceLoader getResourceLoader(){
        return this.resourceLoader;
    }
}
