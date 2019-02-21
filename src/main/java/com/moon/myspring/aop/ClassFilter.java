package com.moon.myspring.aop;

public interface ClassFilter {

    Boolean matchers(Class beanClass) throws Exception;
}
