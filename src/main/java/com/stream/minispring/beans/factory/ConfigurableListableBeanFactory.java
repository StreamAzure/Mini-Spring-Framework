package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.factory.config.AutowireCapableBeanFactory;
import com.stream.minispring.beans.factory.config.BeanDefinition;
import com.stream.minispring.beans.factory.config.ConfigurableBeanFactory;

/**
 * 集大成的工厂接口
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws Exception 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;
}
