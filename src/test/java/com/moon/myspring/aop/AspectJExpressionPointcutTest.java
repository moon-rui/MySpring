package com.moon.myspring.aop;

import com.moon.myspring.HelloService;
import com.moon.myspring.HelloServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author LRui
 * @date 2019-2-20 16:45
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expresson = "execution(* com.moon.myspring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expresson);
        Boolean matches = aspectJExpressionPointcut.matchers(HelloService.class);
        assertTrue(matches);
    }

    @Test
    public void testMethodMatcher() throws Exception {
        String expression = "execution(* com.moon.myspring.*.sayHello(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        Boolean matches = aspectJExpressionPointcut.matchers(HelloServiceImpl.class.getDeclaredMethod("sayHello"),
                HelloServiceImpl.class);
        assertTrue(matches);
    }
}
