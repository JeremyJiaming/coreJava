package com.jeremy.io.imooc.mc_05;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 5-2 字符流之文件读写流
 */
public class FrAndFwDemo {
    public static void main(String[] args) throws IOException{
        //FileReader & FileWriter 不带编码参数，∴只能解析和项目编码相同的文件
        FileReader fr = new FileReader("D:\\迅雷下载\\idea快捷键1.txt");
        FileWriter fw = new FileWriter("D:\\迅雷下载\\idea快捷键2.txt");

        char[] buffer = new char[2056];
        int c;
        while ((c = fr.read(buffer,0,buffer.length))!=-1){
            System.out.println(new String(buffer,0,c));

            fw.write(buffer,0,c);
            fw.flush();
        }

        fr.close();
        fw.close();
    }
}
