package com.stream.minispring.beans.factory.config;

import com.stream.minispring.beans.factory.HierarchicalBeanFactory;

/**
 * 配置 Bean 工厂，对上级接口 HierarchicalBeanFactory 增强
 * 具有分层、注册单例Bean的能力
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{
}
