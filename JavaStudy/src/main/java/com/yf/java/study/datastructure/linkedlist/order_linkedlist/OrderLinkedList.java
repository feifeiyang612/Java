package com.yf.java.study.datastructure.linkedlist.order_linkedlist;

/**
 * @Author: YangFei
 * @Description: 有序链表
 * 链表中的数据存储是有序的；
 * @create: 2019-12-08 23:46
 */
public class OrderLinkedList {
    private Node head;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public OrderLinkedList() {
        this.head = null;
    }

    //插入节点，并按照从小打到的顺序排列
    public void insert(int value) {

        Node node = new Node(value);
        Node pre = null;
        //对象赋值，head和current指向内存堆中同一个对象
        Node current = head;
        while (current != null && value > current.data) {
            //对象赋值，current和pre指向内存堆中同一个对象
            pre = current;
            current = current.next;
        }
        if (pre == null) {
            head = node;
            head.next = current;
        } else {
            pre.next = node;
            node.next = current;
        }
    }

    //删除头节点
    public void delete() {
        head = head.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }
        System.out.println("");
    }
}
