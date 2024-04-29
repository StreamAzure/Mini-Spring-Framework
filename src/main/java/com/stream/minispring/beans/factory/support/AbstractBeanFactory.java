package com.stream.minispring.beans.factory.support;

import com.stream.minispring.beans.factory.BeanFactory;
import com.stream.minispring.beans.factory.config.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象类工厂
 * 继承 DefaultSingletonBeanRegistry，Map、Bean实例的添加和获取
 * 实现 BeanFactory 接口，具有获取 Bean 的能力，具体逻辑为：
 * 1. 先尝试直接直接调用父类getSingleton方法获取 Bean 实例，
 * 2. 若无对应Bean实例，获取BeanDefinition，再根据该BeanDefinition当场创建Bean实例
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception{
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return ((T) getBean(name));
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;
}
