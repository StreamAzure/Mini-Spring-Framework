package com.stream.minispring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.stream.minispring.beans.factory.config.BeanReference;
import com.stream.minispring.beans.PropertyValue;
import com.stream.minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Field;

public abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        return doCreateBean(beanName, beanDefinition);
    }

    /**
     * 具体的 Bean 实例创建逻辑
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            bean = beanClass.newInstance(); // 反射机制创建实例
            // 填充属性
            applyPropertyValues(bean, beanDefinition);
        }catch (Exception e){
            throw new Exception("Instantiation of bean failed", e);
        }
        return bean;
    }

    /**
     * 通过反射为Bean实例填充属性
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
        for(PropertyValue propertyValue: beanDefinition.getPropertyValues().getPropertyValues()){
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                // 如果注入的属性是另一个 Bean
                BeanReference beanReference = (BeanReference) value;
                // 拿到它的name, 再调用 getBean 拿它的实例
                value = getBean(beanReference.getBeanName());
            }
            BeanUtil.setFieldValue(bean, name, value);
        }
    }
}
