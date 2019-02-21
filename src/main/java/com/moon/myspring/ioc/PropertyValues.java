package com.moon.myspring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LRui
 * @date 2019-2-19 14:27
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        // 这里可以对参数值pv做一些处理，如果直接使用List而不用PropertyValues来封装，就无法达到这样的效果
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
