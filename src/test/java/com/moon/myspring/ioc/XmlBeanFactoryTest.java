package com.moon.myspring.ioc;

import com.moon.myspring.Car;
import com.moon.myspring.HelloService;
import com.moon.myspring.Wheel;
import com.moon.myspring.ioc.xml.XmlBeanFactory;
import org.junit.Test;

/**
 * @author LRui
 * @date 2019-2-21 10:31
 */
public class XmlBeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        System.out.println("----- IOC test -----");
        String location = getClass().getClassLoader().getResource("spring.xml").getFile();
        XmlBeanFactory factory = new XmlBeanFactory(location);
        Wheel wheel = (Wheel) factory.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) factory.getBean("car");
        System.out.println(car);

        System.out.println("\n----- AOP test -----");
        HelloService helloService = (HelloService) factory.getBean("helloService");
        helloService.sayHello();
    }
}
