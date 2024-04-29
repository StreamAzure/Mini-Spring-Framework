package com.stream.minispring.beans.factory;

import java.util.Map;

/**
 * 批量获取Bean的工厂，可以列出工厂可以生产的所有Bean实例
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}