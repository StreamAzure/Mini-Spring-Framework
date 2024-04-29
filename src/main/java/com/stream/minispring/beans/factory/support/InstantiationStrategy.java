package com.stream.minispring.beans.factory.support;

import com.stream.minispring.beans.factory.config.BeanDefinition;

/**
 * Bean 的实例化策略
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws Exception;
}
