package com.yf.java.study.datastructure.linkedlist.doublepoint_linkedlist;

/**
 * @Author: YangFei
 * @Description: 双端链表的具体实现
 * @create: 2019-12-08 22:52
 */
public class DoublePointLinkedList {

    //头节点
    private Node head;
    //尾节点
    private Node tail;
    //结点的个数
    private int size;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public DoublePointLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    //链表头新增节点
    public void addHead(Object data) {
        Node node = new Node(data);
        if (size == 0) { //如果链表为空，那么头节点和尾节点都是该新增节点
            this.head = node;
            this.tail = node;
            size++;
        } else {
            node.next = head;
            this.head = node;
            size++;
        }
    }

    //链表尾新增节点
    public void addTail(Object data) {
        Node node = new Node(data);
        if (size == 0) {//如果链表为空，那么头节点和尾节点都是该新增节点
            this.head = node;
            this.tail = node;
            size++;
        } else {
            node.next = null;
            tail = node;
            size++;
        }
    }

    //删除头部节点，成功则返回true，失败则返回false
    public boolean deleteHead() {
        if (size == 0) {
            return false;
        }
        if (head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            head.next = head;
        }
        size--;
        return true;
    }

    //判断是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
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
