package com.moon.myspring;

/**
 * @author LRui
 * @date 2019-2-18 16:19
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
