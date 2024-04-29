package com.stream.minispring.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import com.stream.minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    /**
     * 根据 bean 的无参构造函数实例化对象
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e){
            throw new BeanException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
