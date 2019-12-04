package com.yf.java.study.datastructure.stack.stack_2;

/**
 * @Author: YangFei
 * @Description: 增强功能版栈测试类
 * @create: 2019-12-04 23:19
 */

//测试自定义栈类 ArrayStack
//创建容量为3的栈，然后添加4个元素，2个int，2个String.
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push("yang");
        arrayStack.push(612);
        arrayStack.push("fei");
        arrayStack.push(52);
        System.out.println(arrayStack.peek());
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack.peek());

    }
}
