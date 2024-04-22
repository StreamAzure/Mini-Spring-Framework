package com.stream.test;

public class UserService {
    private String text;
    public UserService(){

    }
    public UserService(String text){
        this.text = text;
    }
    public void queryUserInfo(){
        System.out.println(this.text);
    }
}
