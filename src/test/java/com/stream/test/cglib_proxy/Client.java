package com.stream.test.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new TimerInterceptor());

        Hello hello = (Hello) enhancer.create();
        hello.sayHello("111");
    }
}
