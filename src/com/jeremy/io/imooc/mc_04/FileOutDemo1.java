package com.jeremy.io.imooc.mc_04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 4-3 字节流之文件输出流FileOutputStream
 */
public class FileOutDemo1 {
    public static void main(String[] args) throws IOException {
        //如果该文件不存在，则直接创建，如果存在，删除后创建
        FileOutputStream out = new FileOutputStream("demo/out.dat");
        out.write('a');

        int a = 10;//write只能写八位，那么写一个int需要写4次
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);

        IOUtil.printHex("demo/out.dat");
    }
}
