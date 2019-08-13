package com.jeremy.io.imooc.mc_05;

import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * 5-3 字符流的过滤器
 */
public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("D:\\迅雷下载\\idea快捷键.txt"), "gbk"));
        /*BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("D:\\迅雷下载\\idea快捷键3.txt"),"gbk"));*/
        PrintWriter pw = new PrintWriter("D:\\\\迅雷下载\\\\idea快捷键4.txt");

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);//一次读一行，不能识别换行
           /* bw.write(line);
            //单独写出换行符
            bw.newLine();
            bw.flush();*/
           pw.println(line);
           pw.flush();
        }

        br.close();
        //bw.close();
        pw.close();

    }
}
