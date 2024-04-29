package com.stream.minispring.beans.factory.support;

import com.stream.minispring.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    /**
     * 使用CGLIB动态生成子类
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback((MethodInterceptor) (obj, method, argsTemp, proxy) -> proxy.invokeSuper(obj,argsTemp));
        return enhancer.create();
    }
}