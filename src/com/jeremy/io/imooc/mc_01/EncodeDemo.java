package com.jeremy.io.imooc.mc_01;

import java.io.UnsupportedEncodingException;

/**
 * 1-1 文件的编码
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "家铭ABC";

        //项目默认utf-8，中文占用3个字节
        byte[] bytes1 = s.getBytes("utf-8");
        for (byte b : bytes1) {
            //把字节（转换成了int）以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        //gbk编码中文占用2个字节，英文占用1个字节
        byte[] gbkBytes = s.getBytes("gbk");
        for (byte gbkByte : gbkBytes) {
            System.out.print(Integer.toHexString(gbkByte & 0xff) + " ");
        }
        System.out.println();

        //java是双字节编码 utf-16be
        byte[] javaBytes = s.getBytes("utf-16be");
        //utf-16be 中文占用2个字节，英文占用2个字节
        for (byte javaByte : javaBytes) {
            System.out.print(Integer.toHexString(javaByte & 0xff) + " ");
        }
        System.out.println();

        /**
         * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，
         * 也需要用这种编码方式，否则会出现乱码
         */
        String s1 = new String(javaBytes);//用项目默认的编码，我这里是utf-8
        System.out.println(s1);
        String s2 = new String(javaBytes, "utf-16be");
        System.out.println(s2);


        /**
         * 文本文件 就是字节序列
         * 可以是任意编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ansi编码
         * 联通、联这是一种巧合，他们正好符合了utf-8编码的规则
         */
    }
}
