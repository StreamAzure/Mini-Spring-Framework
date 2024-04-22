package com.stream.minispring.beans.io;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location){
        if(location.startsWith(CLASSPATH_URL_PREFIX)){ // 识别类路径
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else{
            try{
                URL url = new URL(location);
                return new URLResource(url);
            }catch (MalformedURLException e){
                // 如果 URL 格式不合法，当作 File 处理
                return new FileSystemResource(location);
            }
        }
    }
}
