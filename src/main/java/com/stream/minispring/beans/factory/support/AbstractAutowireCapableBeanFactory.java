package com.stream.minispring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.stream.minispring.beans.factory.config.AutowireCapableBeanFactory;
import com.stream.minispring.beans.factory.config.BeanReference;
import com.stream.minispring.beans.PropertyValue;
import com.stream.minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Field;

/**
 * 抽象类工厂
 * 继承了 AbstractBeanFactory，实例化Bean和依赖注入
 */
public abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory implements AutowireCapableBeanFactory {

    // Bean实例化策略，默认使用 SimpleInstantiationStrategy
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

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
            // 灵活采用不同的实例化策略执行bean的实例化
            bean = createBeanInstance(beanDefinition);
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

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy = instantiationStrategy;
    }
}
