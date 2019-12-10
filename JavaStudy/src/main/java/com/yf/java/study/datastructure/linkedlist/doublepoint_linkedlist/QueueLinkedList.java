package com.yf.java.study.datastructure.linkedlist.doublepoint_linkedlist;

/**
 * @Author: YangFei
 * @Description: 用双端链表实现队列，先进先出，队列头部移除元素，队列尾部添加元素
 * @create: 2019-12-08 23:33
 */
public class QueueLinkedList {
    private DoublePointLinkedList doublePointLinkedList;

    public QueueLinkedList() {
        doublePointLinkedList = new DoublePointLinkedList();
    }

    public void insert(Object data) {
        doublePointLinkedList.addTail(data);
    }

    public void delete() {
        doublePointLinkedList.deleteHead();
    }

    public boolean isEmpty() {
        return doublePointLinkedList.isEmpty();
    }

    public int getSize() {
        return doublePointLinkedList.getSize();
    }

    public void display() {
        doublePointLinkedList.display();
    }
}
