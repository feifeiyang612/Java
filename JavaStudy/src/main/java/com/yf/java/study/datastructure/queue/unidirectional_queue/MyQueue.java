package com.yf.java.study.datastructure.queue.unidirectional_queue;

/**
 * @Author: YangFei
 * @Description: 单向队列
 * @create: 2019-12-05 23:19
 */
public class MyQueue {

    private Object[] queArray;
    //队列总大小
    private int maxSize;
    //队列前端
    private int front;
    //队列后端
    private int rear;
    //队列中元素的实际数目
    private int nItems;

    public MyQueue(int s) {
        this.maxSize = s;
        this.queArray = new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    //队列中新增数据
    public void insert(int value) {
        if (isFull()) {
            System.out.println("队列已满！！！");
        } else {
            //如果队列尾部指向顶了，那么循环回来，执行队列的第一个元素
            if (rear == maxSize - 1) {
                rear = -1;
            }
            //队尾指针加1，然后在队尾指针处插入新的数据
            queArray[++rear] = value;
            nItems++;
        }
    }

    //移除队列数据
    public Object remove() {
        Object removeValue = null;
        if (!isEmpty()) {
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }

    //查看队列前端数据
    public Object peekFront() {
        return queArray[front];
    }

    //判断队列是否满了
    public boolean isFull() {
        return (nItems == maxSize);
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return (nItems == 0);
    }

    //返回队列的大小
    public int getSize() {
        return nItems;
    }
}
