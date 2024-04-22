package com.stream.test;

public class OutputService {
    private UserService userService;

    public void output(){
        userService.queryUserInfo();
    }

    public void setUserService(UserService userService){
        this.userService = userService;
    }
}
