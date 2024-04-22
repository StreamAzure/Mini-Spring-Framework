package com.stream.test.io;

import com.stream.minispring.io.Resource;
import com.stream.minispring.io.DefaultResourceLoader;
import org.junit.jupiter.api.Test;

import org.junit.Assert;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("test.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}