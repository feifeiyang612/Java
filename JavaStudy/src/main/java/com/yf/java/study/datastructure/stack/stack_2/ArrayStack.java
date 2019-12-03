package com.yf.java.study.datastructure.stack.stack_2;

import java.util.Arrays;

/**
 * @Author: YangFei
 * @Description:
 * @create: 2019-12-03 23:52
 */
public class ArrayStack {

    //存储元素的数组，声明为Object类型能存储任意类型的数据
    private Object[] elementData;
    //指向栈顶的指征
    private int top;
    //栈的总容量
    private int size;

    //默认构造一个容量为10的栈
    public ArrayStack() {
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    //压入元素
    public Object push(Object item) {
        //是否需要扩容
        isGrow(top++);
        elementData[++top] = item;
        return item;
    }

    private boolean isGrow(int minCapacity) {
        int oldCapacity = this.size;
        //如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
        if (minCapacity >= oldCapacity) {
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            //栈容量扩大两倍（左移一位）看是否超过int类型所表示的最大范围
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1); //左移一位，相当于*2
            }
            this.size = newCapacity;
//            int[] newArray = new int[size];
            elementData = Arrays.copyOf(elementData, size);
            return true;
        } else {
            return false;
        }
    }
}
