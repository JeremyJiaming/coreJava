package com.jeremy.io.imooc.mc_04;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        IOUtil.copyFileByBuffer(new File("D:\\迅雷下载\\GAI-沧海一声笑.mp3"),
                new File("D:\\迅雷下载\\GAI-沧海一声笑_buf.mp3"));
        long endTime = System.currentTimeMillis();
        System.out.println("通过字节缓冲流读取耗时："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        IOUtil.copyFile(new File("D:\\迅雷下载\\GAI-沧海一声笑.mp3"),
                new File("D:\\迅雷下载\\GAI-沧海一声笑_bak.mp3"));
        endTime = System.currentTimeMillis();
        System.out.println("通过字节数组一次性读取耗时："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        IOUtil.copyFileByByte(new File("D:\\迅雷下载\\GAI-沧海一声笑.mp3"),
                new File("D:\\迅雷下载\\GAI-沧海一声笑_byte.mp3"));
        endTime = System.currentTimeMillis();
        System.out.println("一个字节一个字节流读取耗时："+(endTime-startTime));
    }
}
