package com.jeremy.io.imooc.mc_02;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\迅雷下载");
        FileUtils.listDirectory(file);
    }
}
