package com.stream.minispring.beans.factory.support;

import com.stream.minispring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Map: 维护 name 到 BeanDefinition 对象的映射
 * 1. 获取BeanDefinition的具体逻辑
 * 2. 注册BeanDefinition的具体逻辑
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null){
            throw new Exception("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
