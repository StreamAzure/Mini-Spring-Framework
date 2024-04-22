package com.stream.minispring.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;

public class ClassPathResource implements Resource{
    private final String path;
    private ClassLoader classLoader;
    public ClassPathResource(String path){
        this(path,(ClassLoader) null);
    }
    public ClassPathResource(String path, ClassLoader classLoader){
        Assert.assertNotNull("Path must not be null", path);
        Assert.assertNotNull("classLoader must not be null", classLoader);
        this.path = path;
        this.classLoader = classLoader != null ? classLoader: getDefaultClassLoader();
    }
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null){
            throw new FileNotFoundException (this.path);
        }
        return is;
    }

    private ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try{
            // 默认使用当前线程的上下文类加载器
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex){

        }
        return cl;
    }
}
