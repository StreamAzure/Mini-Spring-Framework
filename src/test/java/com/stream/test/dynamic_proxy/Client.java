package com.stream.test.dynamic_proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Client {
    @Test
    public void test(){
        Star1 star1 = new Star1();
        Star2 star2 = new Star2();
        ProxyFactory proxyFactory = new ProxyFactory(star2);
        Action proxy  = (Action) proxyFactory.getProxyInstance();
        proxy.sing("111");
        proxyFactory.setTarget(star1);
        Action proxy2 = (Action) proxyFactory.getProxyInstance();
        proxy2.sing("222");

    }
}
