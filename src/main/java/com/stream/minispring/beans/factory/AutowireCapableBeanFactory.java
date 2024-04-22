package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.BeanDefinition;
import com.stream.minispring.beans.BeanReference;
import com.stream.minispring.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * 一个 Bean 工厂类
 * 具体执行类的实例化
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition); // 属性注入
        return bean;
    }

    // 通过反射实例化对象
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    // 通过反射注入属性
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
        for(PropertyValue propertyValue: beanDefinition.getPropertyValues().getPropertyValues()){
            Field declaredFiled = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredFiled.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                // 如果注入的属性是另一个 Bean
                BeanReference beanReference = (BeanReference) value;
                // 拿到它的name, 再调用 getBean 拿它的实例
                value = getBean(beanReference.getName());
            }
            declaredFiled.set(bean, value);
        }
    }
}
