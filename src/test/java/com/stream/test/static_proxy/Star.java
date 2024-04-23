package com.stream.test.static_proxy;

public class Star implements Action{
    @Override
    public void sing(String name) {
        System.out.println("下面为大家演唱：" + name);
    }
}
