package com.stream.minispring.beans.factory.xml;

import com.stream.minispring.beans.factory.support.AbstractBeanDefinitionReader;
import com.stream.minispring.beans.factory.config.BeanDefinition;
import com.stream.minispring.beans.factory.config.BeanReference;
import com.stream.minispring.beans.PropertyValue;
import com.stream.minispring.beans.factory.support.BeanDefinitionRegistry;
import com.stream.minispring.io.DefaultResourceLoader;

import com.stream.minispring.io.Resource;
import com.stream.minispring.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XMLBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XMLBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XMLBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 通过路径加载资源
     * @param location
     * @throws Exception
     */
    @Override
    public void loadBeanDefinitions(String location) throws Exception {
       ResourceLoader resourceLoader = getResourceLoader();
       Resource resource = resourceLoader.getResource(location);
       loadBeanDefinitions(resource);
    }

    /**
     * 通过 Resource 对象加载资源
     * @param resource
     * @throws Exception
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception{
        // 读取XML文件内容
        InputStream inputStream = resource.getInputStream();
//        printInputStreamContents(inputStream);
        doLoadBeanDefinitions(inputStream);
    }

    /**
     * 打印 IO 流
     * @param inputStream
     */
    private static void printInputStreamContents(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        // 读取XML
        Document doc = documentBuilder.parse(inputStream);
        // 解析Bean定义
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document doc) throws Exception {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    /**
     * 解析XML文件：Bean定义
     * @param root
     */
    protected void parseBeanDefinitions(Element root) throws Exception {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele) throws Exception {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        Class<?> cls = Class.forName(className);
        BeanDefinition beanDefinition = new BeanDefinition(cls);
        processProperty(ele,beanDefinition);
        getRegistry().registerBeanDefinition(name, beanDefinition);
    }

    /**
     * 解析注入属性
     * @param ele
     * @param beanDefinition
     */
    private void processProperty(Element ele,BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if(value != null && value.length() > 0){
                    // 如果有 value 这个 tag
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                }else{
                    // 没有 value 就视作 ref 这个 tag
                    String ref = propertyEle.getAttribute("ref");
                    if(ref == null || ref.length() == 0){
                        throw new IllegalArgumentException("Configuration Problem: <property> element wrong");
                    }
                    // 用bean的name初始化一个beanReference，再将它作为property的value
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }
}
