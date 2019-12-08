package com.yf.java.study.datastructure.linkedlist.order_linkedlist;

import com.yf.java.study.datastructure.linkedlist.doublepoint_linkedlist.QueueLinkedList;

/**
 * @Author: YangFei
 * @Description:
 * @create: 2019-12-09 00:03
 */
public class OrderLinkedListMain {
    public static void main(String[] args) {
        OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.insert(3);
        orderLinkedList.insert(5);
        orderLinkedList.insert(6);
        orderLinkedList.insert(2);
        orderLinkedList.display();
    }
}
