package com.yf.java.study.datastructure.linkedlist.twoway_linkedlist;

/**
 * @Author: YangFei
 * @Description: 双向链表，双向链表可以从两个方向遍历。
 * @create: 2019-12-10 23:04
 */
public class TwoWayLinkedList {
    //链表头
    private Node head;
    //链表尾
    private Node tail;
    //链表的节点个数
    private int size;

    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }

    public TwoWayLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    //在链表头部增加节点
    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            this.head = newNode;
            this.tail = newNode;
            size++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    //在链表尾部增加节点
    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail.next = newNode;
            size++;
        }
    }

    //删除链表头部
    public Node deleteHead() {
        Node temp = head;
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }

    //删除链表尾部
    public Node deleteTail() {
        Node temp = tail;
        if (size != 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }

    //获得链表的节点个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }
}
