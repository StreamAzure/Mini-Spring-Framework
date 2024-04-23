package com.stream.test.static_proxy;

import org.junit.jupiter.api.Test;

public class Client {
    @Test
    public void test(){
        Proxy proxy = new Proxy(new Star());
        proxy.sing("遥远的彼方");
    }
}
