package com.yf.java.study.datastructure.stack.stack_2;

/**
 * @Author: YangFei
 * @Description: 进行字符串反转
 * @create: 2019-12-04 23:53
 */
public class StringReversalTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        String str = "how are you!";
        char[] cha = str.toCharArray();
        for (char c : cha) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println("");

    }
}
