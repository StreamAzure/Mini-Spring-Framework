package com.stream.test.cglib_proxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimerInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long time = System.nanoTime();
        System.out.println("Invocation of Method " + method.getName() + " start!");
        Object proceed = methodProxy.invokeSuper(o, args);
        System.out.println("Invocation of Method " + method.getName() + " end! takes " + (System.nanoTime() - time)
                + " nanoseconds.");
        return proceed;
    }
}
