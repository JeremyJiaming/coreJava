package com.jeremy.io.imooc.mc_06;

import java.io.Serializable;

public class Student implements Serializable{
    private String stuNo;
    private String stuName;
    //该元素不会进行jvm默认的序列化，也可以自己完成这个元素的序列化
    private transient int stuAge;

    public Student() {
    }

    public Student(String stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
        s.writeInt(stuAge);//自己完成stuage的序列化
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
        this.stuAge=s.readInt();//自己完成stuage的反序列化
    }
}
