package com.stream.minispring.aop;

/**
 * 被代理的对象
 */
public class TargetSource {
    private Object target;
    public TargetSource(Object target){
        this.target = target;
    }
    public Object getTarget() {
        return target;
    }
    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }
}
