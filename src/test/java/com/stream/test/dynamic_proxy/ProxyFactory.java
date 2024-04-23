package com.stream.test.dynamic_proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;
    private Handler handler;
    public ProxyFactory(Object target){
        this(target, new Handler(target));
    }
    public ProxyFactory(Object target, Handler handler){
        this.target = target;
        this.handler = handler;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this.handler
        );
    }
    public void setTarget(Object object){
        this.target = object;
        this.handler.setTarget(target);
    }
}
