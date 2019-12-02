package com.yf.java.study.datastructure.array.sort_algorithm;

/**
 * @Author: YangFei
 * @Description: 插入排序法
 * @create: 2019-12-02 23:29
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        int j;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            //记录要插入的数据
            int tmp = array[i];
            j = i;
            //从已经排序的序列最右边的开始比较，找到比其小的数
            while (j > 0 && tmp < array[j - 1]) {
                //向后挪动
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;//存在比其小的数，插入
        }
        return array;
    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
    }
}
