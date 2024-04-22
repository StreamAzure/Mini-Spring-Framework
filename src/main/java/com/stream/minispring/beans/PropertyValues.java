package com.stream.minispring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 包装一个对象所有的PropertyValue
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    public PropertyValues(){

    }
    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }
    public List<PropertyValue> getPropertyValues(){
        return this.propertyValueList;
    }
}
