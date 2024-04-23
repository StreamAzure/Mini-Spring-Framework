package com.stream.test.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
    Object target;
    public Handler(Object target){
        this.target  = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行");
        Object returnValue = method.invoke(target, args);
        System.out.println("结束执行");
        return returnValue;
    }
    public void setTarget(Object target){
        this.target = target;
    }
}
