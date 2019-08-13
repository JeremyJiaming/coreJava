package com.jeremy.io.imooc.mc_05;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 5-1 字节字符转换流
 */
public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream("D:\\迅雷下载\\idea快捷键.txt");
        InputStreamReader isr = new InputStreamReader(in,"gbk");
        FileOutputStream out = new FileOutputStream("D:\\迅雷下载\\idea快捷键1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out,"gbk");

        System.out.println(Charset.defaultCharset().name());//默认utf-8编码


        //一个字节一个字节 读取
        /*int c;
        while((c=isr.read())!=-1){
            System.out.print((char) c);
        }*/

        //批量读取
        //放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length个
        //返回读到的字符的个数
        char[] buffer = new char[8*1024];
        int c;
        while ((c=isr.read(buffer,0,buffer.length)) != -1){
            String s = new String(buffer,0,c);
            System.out.println(s);

            osw.write(buffer,0,c);
            osw.flush();
        }

        osw.close();
        isr.close();
    }
}
