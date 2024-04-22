package com.stream.minispring.beans;

import com.stream.minispring.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanDefinition 抽象工厂
 *
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }
    public Map<String, BeanDefinition> getRegistry(){
        return this.registry;
    }
    public ResourceLoader getResourceLoader(){
        return this.resourceLoader;
    }
}
