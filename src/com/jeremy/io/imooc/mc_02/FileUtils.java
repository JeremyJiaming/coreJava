package com.jeremy.io.imooc.mc_02;

import java.io.File;
import java.io.IOException;

/**
 * 2-2 遍历目录
 */
public class FileUtils {
    /**
     * 列出指定目录下（包括其子目录）的所有文件
     *
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在.");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }

        /*String[] fileNames = dir.list();//返回的是直接子目录名称的字符串数组
        for (String fileName : fileNames) {
            System.out.println(dir + File.separator + fileName);
        }*/

        //如果要遍历子目录下的目录就需要构造成File对象做递归操作
        File[] files = dir.listFiles();//返回直接子目录文件的抽象

        if(files != null && files.length != 0){
            for (File file : files) {
                if(file.isDirectory()){
                    //递归
                    listDirectory(file);
                }
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
