package com.stream.test.dynamic_proxy;

public class Star1 implements Action{
    @Override
    public void sing(String name) {
        System.out.println("Star1 演唱：" + name);
    }
}
