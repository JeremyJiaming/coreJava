package com.jeremy.io.imooc.mc_06;

import java.io.*;

public class ObjectSerailDemo2 {
    public static void main(String[] args) throws Exception{
        File file = new File("demo/obj1.dat");
//        ObjectOutputStream oos = new ObjectOutputStream(
////                new FileOutputStream(file));
////        Foo2 foo2 = new Foo2();
////        oos.writeObject(foo2);
////        oos.flush();
////        oos.close();

//        ObjectInputStream ois = new ObjectInputStream(
//                new FileInputStream(file));
//        Foo2 foo2 = (Foo2) ois.readObject();
//        ois.close();

//        ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream(file));
//        Bar2 bar2 = new Bar2();
//        oos.writeObject(bar2);
//        oos.flush();
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        Bar2 bar2 = (Bar2) ois.readObject();
        ois.close();
    }
}

/**
 * 一个类实现了序列化接口，那么其子类都可以进行序列化
 */
class Foo implements Serializable{
    public Foo(){
        System.out.println("Foo...");
    }
}

class Foo1 extends Foo{
    public Foo1(){
        System.out.println("Foo1...");
    }
}

class Foo2 extends Foo1{
    public Foo2(){
        System.out.println("Foo2...");
    }
}

/**
 * 对子类对象进行反序列化操作时，
 * 如果其父类没有实现序列化接口，
 * 那么其父类的构造函数会被调用
 */
class Bar{
    public Bar() {
        System.out.println("Bar...");
    }
}

class Bar1 extends Bar implements Serializable{
    public Bar1() {
        System.out.println("Bar1...");
    }
}

class Bar2 extends Bar1{
    public Bar2() {
        System.out.println("Bar2...");
    }
}