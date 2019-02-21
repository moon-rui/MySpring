package com.moon.myspring.aop;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
