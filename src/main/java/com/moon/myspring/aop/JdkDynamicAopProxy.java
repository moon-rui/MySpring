package com.moon.myspring.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LRui
 * @date 2019-2-20 16:03
 */
final public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        super(advisedSupport);
    }

    /**
     * 为目标bean生成代理对象
     * @return bean的代理对象
     */
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advisedSupport.getTargetSource().getInterfaces(), this);
    }

    /**
     * InvocationHandler接口中invoke方法的具体实现，封装了具体的代理逻辑
     * @param proxy
     * @param method
     * @param args
     * @return 代理方法或原方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodMatcher methodMatcher = advisedSupport.getMethodMatcher();

        // 使用方法匹配器methodMatcher检查bean中的原始方法method是否符合匹配规则
        if (methodMatcher != null && methodMatcher.matchers(method, advisedSupport.getClass())) {
            // 获取Advice，MethodInterceptor的父接口继承了Advice
            MethodInterceptor methodInterceptor = advisedSupport.getMethodInterceptor();
            // 将bean的原始method封装成MethodInvocation对象
            // 将生成的对象传给Advice实现类对象，执行通知逻辑
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args));
        } else {
            // 当前method不符合匹配规则，直接调用bean中的原始method
            return method.invoke(advisedSupport.getTargetSource().getTarget(), args);
        }
    }
}
