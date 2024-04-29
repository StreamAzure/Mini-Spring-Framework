package com.stream.minispring.beans.factory.config;

public class BeanReference {
    private String beanName;
    private Object bean;
    public BeanReference(String name){
        this.beanName = name;
    }
    public String getBeanName() {
        return this.beanName;
    }

    public void setBeanName(String name) {
        this.beanName = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
