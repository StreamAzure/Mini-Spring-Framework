package com.stream.minispring.beans.factory;

import com.stream.minispring.beans.factory.config.BeanDefinition;

public interface BeanFactory {
    /**
     * 获取Bean
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}
