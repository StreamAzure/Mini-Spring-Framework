package com.stream.minispring.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK的动态代理
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    private AdvisedSupport advised;
    public JdkDynamicAopProxy(AdvisedSupport advised){
        this.advised = advised;
    }
    @Override
    public Object getProxy() {
        // Java 动态代理
        // 传入ClassLoader
        // 传入要实现的一组接口
        // 以及 InvocationHandler 实例，这里就是 jdkDynamicAopProxy 自己
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                advised.getTargetSource().getTargetClass(),
                this);
    }

    // 所有通过代理对象进行的方法调用都会被转发到 invoke 方法
    // proxy 为代理对象本身，method 为代理对象要调用的方法，args 为这个方法的参数
    // 代理对象调用方法时，都会执行用户定义的拦截器对象中的 invoke 方法
    // ReflectiveMethodInvocation 对象用来将被代理对象的相关信息传入拦截器
    // 拦截器内部通过该对象实际调用要调用的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        return methodInterceptor.invoke(
                new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args)
        );
    }
}
