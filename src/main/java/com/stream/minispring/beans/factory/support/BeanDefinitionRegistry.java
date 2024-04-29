package com.stream.minispring.beans.factory.support;

import com.stream.minispring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     * @throws Exception
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;

    /**
     * 根据 BeanName 查找 BeanDefinition
     * @param beanName
     * @return
     * @throws Exception
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回定义的所有 bean 的名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
