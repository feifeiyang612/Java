package com.yf.java.study.datastructure.array;

import java.util.ArrayList;

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
    public MyArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    //构造函数，初始化一个长度为length的数组
    public MyArray(int length) {
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    /**
     * 获取数组的有效长度
     */
    int getSize() {
        return elems;
    }

    /**
     * 遍历显示元素
     */
    public void display() {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * 添加元素
     *
     * @param value,假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响。
     * @return 添加成功返回true, 添加的元素超过范围了返回false
     */
    public boolean add(int value) {
        if (elems == length) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    /**
     * 根据下标获取元素
     *
     * @param i
     * @return 查找下标值在数组下标有效范围内，返回下标所表示的元素 查找下标超出数组下标有效值，提示访问下标越界
     */
    public int get(int i) {
        if (i < 0 || i > elems) {
            System.out.println("访问下标越界！");
        }
        return intArray[i];
    }

    /**
     * 查找元素是否存在，返回元素下标
     *
     * @param searchValue
     * @return 查找的元素如果存在则返回下标值，如果不存在，返回 -1
     */
    public int find(int searchValue) {
        int i;
        for (i = 0; i < elems; i++) {
            if (intArray[i] == searchValue) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    /**
     * 删除元素
     *
     * @param value
     * @return 如果要删除的值不存在，直接返回false;否则返回true，删除成功
     */
    public boolean delete(int value) {
        int k = find(value);
        if (k == -1) {
            return false;
        } else {
            if (k == elems - 1) {
                int [] newArray = new int[elems - 1];
                for (int j = 0; j < elems - 1; j++) {
                    newArray[j] = intArray[j];
                }
                intArray = newArray;
                elems--;
            } else {
                int [] newArray = new int[elems - 1];
                for (int j = 0; j < k; j++) {
                    newArray[j] = intArray[j];
                }
                for (int i = k; i < elems - 1; i++) {
                    newArray[i] = intArray[i + 1];
                }
                intArray = newArray;
                elems--;
            }
            return true;
        }
    }

    /**
     * 修改数据
     *
     * @param oldValue 原值
     * @param newValue 新值
     * @return修改成功返回true，修改失败返回false
     */
    public boolean modify(int oldValue, int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            System.out.println("需要修改的数据不存在");
            return false;
        } else {
            intArray[i] = newValue;
            return true;
        }
    }

}

