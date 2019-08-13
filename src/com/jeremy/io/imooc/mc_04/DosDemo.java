package com.jeremy.io.imooc.mc_04;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 4-4 字节流值数据输入输出流
 */
public class DosDemo {
    public static void main(String[] args) throws IOException{
        String file = "demo/dos.dat";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //采用utf-8编码写出
        dos.writeUTF("中国");
        //采用utf-16be编码写出
        dos.writeChars("中国");

        dos.close();

        IOUtil.printHex("demo/dos.dat");
    }
}
