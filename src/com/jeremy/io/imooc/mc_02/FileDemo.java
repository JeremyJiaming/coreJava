package com.jeremy.io.imooc.mc_02;

import java.io.File;
import java.io.IOException;

/**
 * 2-1 File 类常用API介绍
 */
public class FileDemo {
    public static void main(String[] args) {
        //了解构造函数的情况
        File file = new File("E:\\Jeremy");//路径中用双正斜（需要转义）或者单反斜
        //File file2 = new File("E:"+File.separator+"Jeremy");// 建议这样使用，∵windows和linux系统通用

        if (!file.exists()) {
            file.mkdir();
        }else {
            file.delete();
        }

        //是否是一个目录,如果是目录返回true，如果不是目录or目录不存在返回的是false
        System.out.println(file.isDirectory());

        //是否是一个文件
        System.out.println(file.isFile());

        //创建文件
        File file3 = new File("E:"+File.separator+"Jeremy", "日记.txt");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file3.delete();
        }

        //常用File对象的API
        System.out.println(file);//file.toString()的内容
        System.out.println(file.getAbsoluteFile());//file绝对路径
        System.out.println(file.getName());//file的名字
        System.out.println(file.getParent());//file父目录的名字
        System.out.println(file.getParentFile().getAbsoluteFile());//file父目录绝对路径
    }
}
