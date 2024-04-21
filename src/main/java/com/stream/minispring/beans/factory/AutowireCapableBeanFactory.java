package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.BeanDefinition;

/**
 * 具体执行类的实例化
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try{
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }
}
