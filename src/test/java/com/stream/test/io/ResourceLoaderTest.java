package com.stream.test.io;

import com.stream.minispring.beans.io.Resource;
import com.stream.minispring.beans.io.ResourceLoader;
import org.junit.jupiter.api.Test;

import org.junit.Assert;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("test.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}