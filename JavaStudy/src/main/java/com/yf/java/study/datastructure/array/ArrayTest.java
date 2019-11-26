package com.yf.java.study.datastructure.array;

/**
 * @Author: YangFei
 * @Description: 数据结构之【数组Array】
 * @create: 2019-11-25 23:46
 */
public class ArrayTest {
    public static void main(String[] args) {
        //声明数组1,声明一个长度为3，只能存放int类型的数据
        int[] myArray1 = new int[3];
        //声明数组2,声明一个数组元素为 1,2,3的int类型数组
        int[] myArray2 = {1, 2, 3};
        //给myArray第一个元素赋值1
        myArray1[0] = 6;
        //访问myArray的第一个元素
        System.out.println(myArray1[1]);
        for (int i = 0; i < myArray2.length; i++) {
            System.out.println(myArray2[i]);

        }
    }
}
