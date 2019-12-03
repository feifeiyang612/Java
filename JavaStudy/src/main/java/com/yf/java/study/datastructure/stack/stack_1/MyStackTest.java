package com.yf.java.study.datastructure.stack.stack_1;

import com.yf.java.study.datastructure.stack.stack_1.MyStack;

/**
 * @Author: YangFei
 * @Description: 测试栈
 * @create: 2019-12-03 23:40
 */
public class MyStackTest  {

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        while (! stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
