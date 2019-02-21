package com.moon.myspring.aop;

/**
 * @author LRui
 * @date 2019-2-20 11:41
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advisedSupport;

    public AbstractAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
}
