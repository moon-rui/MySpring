package com.moon.myspring.aop;

import com.moon.myspring.HelloService;
import com.moon.myspring.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author LRui
 * @date 2019-2-20 16:34
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void getProxy() {
        System.out.println("----- no proxy -----");
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHello();

        System.out.println("\n----- proxy -----");
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new LogInterceptor());
        TargetSource targetSource = new TargetSource(helloService, HelloServiceImpl.class, HelloServiceImpl.class.getInterfaces());
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodMatcher((Method method, Class beanClass) -> true);

        helloService = (HelloService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        helloService.sayHello();
    }
}
