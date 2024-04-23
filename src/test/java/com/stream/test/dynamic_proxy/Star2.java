package com.stream.test.dynamic_proxy;

public class Star2 implements Action{
    @Override
    public void sing(String name) {
        System.out.println("Star2 演唱" + name);
    }
}
