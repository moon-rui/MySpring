package com.moon.myspring.ioc;

public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
