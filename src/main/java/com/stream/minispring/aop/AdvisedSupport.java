package com.stream.minispring.aop;
import org.aopalliance.intercept.MethodInterceptor;
/**
 * 代理元数据
 */
public class AdvisedSupport {
    // 被代理的目标对象
    private TargetSource targetSource;
    // 方法拦截器，由用户具体实现并传入
    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource(){
        return targetSource;
    }
    public void setTargetSource(TargetSource targetSource){
        this.targetSource = targetSource;
    }
    public MethodInterceptor getMethodInterceptor(){
        return methodInterceptor;
    }
    public void setMethodInterceptor(MethodInterceptor methodInterceptor){
        this.methodInterceptor = methodInterceptor;
    }
}
