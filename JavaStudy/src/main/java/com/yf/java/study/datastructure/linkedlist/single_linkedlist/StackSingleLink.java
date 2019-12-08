package com.yf.java.study.datastructure.linkedlist.single_linkedlist;

/**
 * @Author: YangFei
 * @Description: 用单向链表实现【栈】
 * 栈的pop()方法和push()方法，对应于链表的在头部删除元素deleteHead()以及在头部增加元素addHead();
 * @create: 2019-12-08 22:21
 */
public class StackSingleLink {

    private SingleLinkedList singleLinkedList;

    public StackSingleLink(){
        singleLinkedList = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj){
        singleLinkedList.addHead(obj);
    }

    //移除栈顶元素
    public Object pop(){
        Object object = singleLinkedList.deleteHead();
        return object;
    }

    //判断是否为空
    public boolean isEmpty(){
        return singleLinkedList.isEmpty();
    }

    //打印栈内元素信息
    public void display(){
        singleLinkedList.display();
    }
}
