package com.stream.minispring.context;

import com.stream.minispring.beans.BeanDefinition;
import com.stream.minispring.beans.factory.AbstractBeanFactory;
import com.stream.minispring.beans.factory.AutowireCapableBeanFactory;
import com.stream.minispring.beans.xml.XMLBeanDefinitionReader;
import com.stream.minispring.io.DefaultResourceLoader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    private String configLocation;
    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation, new AutowireCapableBeanFactory());
        // 默认使用 AutowireCapableBeanFactory 这个 Bean 工厂
    }
    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception{
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception{
        // 将读取XML文件、注册Bean的步骤集中到这里完成
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new DefaultResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
