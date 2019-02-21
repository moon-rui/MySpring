package com.moon.myspring.simple;

import com.moon.myspring.HelloService;
import com.moon.myspring.HelloServiceImpl;
import org.junit.Test;

/**
 * @author LRui
 * @date 2019-2-18 16:21
 */
public class SimpleAOPTest {

    @Test
    public void getProxy() {
        // 1. 创建MethodInvation实现类
        MethodInvocation logTask = () -> System.out.println("log start");
        HelloServiceImpl helloService = new HelloServiceImpl();

        // 2. 创建一个Advice
        Advice beforeAdvice = new BeforeAdvice(helloService, logTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceProxy = (HelloService) SimpleAOP.getProxy(helloService, beforeAdvice);
        helloServiceProxy.sayHello();
    }
}
