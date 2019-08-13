package com.jeremy.io.imooc.mc_06;
/**
 * 6-1 序列化基本操作
 */

import java.io.*;

public class ObjectSerialDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "demo/obj.dat";
        //对象的序列化
//        ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream(file));
//        Student student = new Student("10001","张三",18);
//        oos.writeObject(student);
//        oos.flush();
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );
        Student student = (Student)ois.readObject();
        System.out.println(student);
        ois.close();
    }
}
