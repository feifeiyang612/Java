package com.yf.java.study.datastructure.stack.stack_1;

/**
 * @Author: YangFei
 * @Description: Java模拟简单的顺序栈实现
 * @create: 2019-12-03 23:27
 */
public class MyStack {

    private int[] array;
    private int maxSize;
    //top变量指向的始终是栈顶的元素
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //压入数据
    public void push(int value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        }
    }

    //弹出栈顶数据
    public int pop() {
        return array[top--];
    }

    //访问栈顶数据
    public int peek() {
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty() {
//        return array.length < 1 ? true : false;
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
