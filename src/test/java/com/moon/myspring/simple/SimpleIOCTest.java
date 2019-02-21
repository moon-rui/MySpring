package com.moon.myspring.simple;

import com.moon.myspring.Car;
import com.moon.myspring.Wheel;
import org.junit.Test;

/**
 * @author LRui
 * @date 2019-2-18 15:16
 */
public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("spring-ioc.xml").getFile();
        SimpleIOC simpleIOC = new SimpleIOC(location);
        Wheel wheel = (Wheel) simpleIOC.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) simpleIOC.getBean("car");
        System.out.println(car);
    }
}
