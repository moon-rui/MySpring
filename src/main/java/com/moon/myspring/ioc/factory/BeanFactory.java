package com.moon.myspring.ioc.factory;

public interface BeanFactory {

    Object getBean(String beanId) throws Exception;
}
