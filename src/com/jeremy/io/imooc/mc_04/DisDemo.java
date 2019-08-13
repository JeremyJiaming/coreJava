package com.jeremy.io.imooc.mc_04;

import java.io.*;

/**
 * 4-4 字节流值数据输入输出流
 */
public class DisDemo {
    public static void main(String[] args) throws IOException{
        String file = "demo/dos.dat";
        DataInputStream din = new DataInputStream(new FileInputStream(file));

        int i = din.readInt();
        System.out.println(i);

        i = din.readInt();
        System.out.println(i);

        long l = din.readLong();
        System.out.println(l);

        double v = din.readDouble();
        System.out.println(v);

        String s = din.readUTF();
        System.out.println(s);

        char c = din.readChar();
        System.out.println(c);

        din.close();
    }
}
