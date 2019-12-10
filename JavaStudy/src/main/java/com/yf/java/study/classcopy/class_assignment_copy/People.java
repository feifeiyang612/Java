package com.yf.java.study.classcopy.class_assignment_copy;

/**
 * @Author: YangFei
 * @Description: 对象赋值的实例，对象赋值实质上是两个不同的对象指向内存堆中同一个对象
 * @create: 2019-12-10 22:12
 */
public class People {

    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
