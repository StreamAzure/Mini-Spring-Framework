package com.stream.test.ioc.service;

public class UserServiceImpl implements UserService{
    private String text;
    public void setText(String text){
        this.text = text;
    }
    public void queryUserInfo(){
        System.out.println(this.text);
    }
}
