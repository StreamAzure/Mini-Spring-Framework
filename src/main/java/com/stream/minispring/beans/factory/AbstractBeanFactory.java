package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * 实例化 bean，交给子类完成
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
