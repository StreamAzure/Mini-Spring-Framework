package com.stream.minispring.beans.factory.config;

import com.stream.minispring.beans.factory.BeanFactory;

/**
 * 自动装配的Bean工厂
 * 对于想要拥有自动装配能力，并且想把这种能力暴露给外部应用的BeanFactory类需要实现此接口
 * 为Spring框架之外的程序提供自动装配的接口
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

}
