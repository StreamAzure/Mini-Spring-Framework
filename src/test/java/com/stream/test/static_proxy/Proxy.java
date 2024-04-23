package com.stream.test.static_proxy;

public class Proxy implements Action{
    private Action person;
    public Proxy(Action person){
        this.person = person;
    }
    @Override
    public void sing(String name) {
        System.out.println("日志");
        person.sing(name);
    }
}
