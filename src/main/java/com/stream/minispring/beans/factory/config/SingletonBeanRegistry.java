package com.stream.minispring.beans.factory.config;

public interface SingletonBeanRegistry {
    /**
     * 单例注册表
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
