package com.jeremy.io.imooc.mc_04;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {
    public static void main(String[] args) throws IOException {
        IOUtil.copyFile(new File("D:\\迅雷下载\\FileUtils.java"),
                new File("D:\\迅雷下载\\FileUtils_bak.java"));
    }
}
