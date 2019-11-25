package com.yf.java.study.array;

/**
 * @Author: YangFei
 * @Description: 用类封装数组实现数据结构
 * @create: 2019-11-25 23:54
 */
public class MyArray {
    //定义一个数组
    private int[] intArray;
    //定义数组的实际有效长度
    private int elems;
    //定义数组的最大长度
    private int length;

    //默认构造一个长度为50的数组
    public MyArray(){
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

     //构造函数，初始化一个长度为length的数组
    public MyArray(int length){
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    //获取数组的有效长度
    int getSize(){
        return elems;
    }
   /**
      * 遍历显示元素
       */
   public void display(){
       for (int i = 0; i < intArray.length; i++) {
           System.out.println(intArray[i] + "");
       }
       System.out.println();
   }

}
