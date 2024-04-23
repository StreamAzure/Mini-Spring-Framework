package com.stream.minispring.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglib2AopProxy implements AopProxy{
    private AdvisedSupport advised;
    public Cglib2AopProxy(AdvisedSupport advised){
        this.advised = advised;
    }
    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTarget().getClass());
        enhancer.setInterfaces(advised.getTargetSource().getTargetClass());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        return enhancer.create();
    }

    private static class DynamicAdvisedInterceptor implements MethodInterceptor{
        private AdvisedSupport advised;
        public DynamicAdvisedInterceptor(AdvisedSupport advised){
            this.advised = advised;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            // 负责拦截方法调用
            // 创建 CglibMethodInvocation 对象，它封装所有调用细节，提供了调用目标方法的API
            CglibMethodInvocation methodInvocation =
                    new CglibMethodInvocation(advised.getTargetSource().getTarget(),
                            method, args, methodProxy);
            // 将 methodInvocation 作为参数传入拦截器，以便拦截器在完成切面逻辑之后可以推进目标方法的执行
            return advised.getMethodInterceptor().invoke(methodInvocation);
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {
        private MethodProxy methodProxy;
        public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
            super(target, method, args);
            this.methodProxy = methodProxy;
        }
        @Override
        public Object proceed() throws Throwable {
            // 实际执行目标方法
            return this.methodProxy.invoke(this.target, this.args);
        }

    }
}
