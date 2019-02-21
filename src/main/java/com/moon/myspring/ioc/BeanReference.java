package com.moon.myspring.ioc;

/**
 * @author LRui
 * @date 2019-2-19 14:34
 */
public class BeanReference {

    private String name;

    private Object bean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public BeanReference(String name) {

        this.name = name;
    }
}
