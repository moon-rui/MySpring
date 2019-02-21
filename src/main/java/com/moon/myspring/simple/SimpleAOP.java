package com.moon.myspring.simple;

import java.lang.reflect.Proxy;

/**
 * @author LRui
 * @date 2019-2-18 16:16
 */
public class SimpleAOP {

    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
    }
}
