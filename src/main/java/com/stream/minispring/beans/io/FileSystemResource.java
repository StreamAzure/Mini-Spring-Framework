package com.stream.minispring.beans.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource{
    private final File file;
    private final String path;

    // 传入的是文件对象
    public FileSystemResource(File file){
        this.file = file;
        this.path = file.getPath();
    }

    // 传入的是文件路径
    public FileSystemResource(String path){
        this.file = new File(path);
        this.path = path;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
    public final String getPath(){
        return this.path;
    }
}
