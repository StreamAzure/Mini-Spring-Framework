package com.stream.test.aop;

import com.stream.minispring.aop.AdvisedSupport;
import com.stream.minispring.aop.Cglib2AopProxy;
import com.stream.minispring.aop.JdkDynamicAopProxy;
import com.stream.minispring.aop.TargetSource;
import com.stream.minispring.context.ApplicationContext;
import com.stream.minispring.context.ClassPathXmlApplicationContext;
import com.stream.test.UserService;
import org.junit.jupiter.api.Test;

public class AopProxyTest {
    @Test
    public void testInterceptor() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/test/resources/test.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");
        // 无拦截器的调用
        userService.queryUserInfo();

        // 1. 设置被代理对象
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(userService);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器 Advice
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 设置代理
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        UserService userService1 = (UserService) jdkDynamicAopProxy.getProxy();

        // 4. 调用
        userService1.queryUserInfo();
    }

    @Test
    public void testCGLIB() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/test/resources/test.xml");
        UserService userService = (UserService) applicationContext.getBean("UserService");

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new TimerInterceptor());

        // 代理对象(Cglib2AopProxy)
        UserService proxy_cglib = (UserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        proxy_cglib.queryUserInfo();

    }
}
