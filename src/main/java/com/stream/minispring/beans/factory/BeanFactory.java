package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.factory.config.BeanDefinition;

/**
 * 工厂模式的工厂接口，IOC始祖
 */
public interface BeanFactory {
    /**
     * 根据名称获取Bean
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;

    /**
     * 根据名称和类型获取bean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getBean(String name, Class<T> requiredType) throws Exception;
}
