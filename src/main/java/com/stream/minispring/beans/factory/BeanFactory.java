package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.factory.config.BeanDefinition;

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
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws Exception;
}
