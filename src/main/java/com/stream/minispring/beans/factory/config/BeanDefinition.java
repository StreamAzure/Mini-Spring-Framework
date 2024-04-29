package com.stream.minispring.beans.factory.config;

import com.stream.minispring.beans.PropertyValues;


/**
 * 保存bean的元数据，如class类型等
 */
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues(){
        return this.propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues){
        this.propertyValues = propertyValues;
    }
}
