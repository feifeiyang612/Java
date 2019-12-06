package com.yf.java.study.datastructure.queue.priority_queue;

/**
 * @Author: YangFei
 * @Description: 优先级队列
 * @create: 2019-12-06 16:37
 */
public class PriorityQueue {
    //队列总大小
    private int maxSize;
    //优先级队列数组
    private int[] priQueArray;
    //队列实际元素数量
    private int nItems;

    public PriorityQueue(int s) {
        this.maxSize = s;
        this.priQueArray = new int[maxSize];
        this.nItems = 0;
    }

    //插入数据
    public void insert(int value) {
        int j;
        if (nItems == 0) {
            priQueArray[nItems++] = value;
        } else if (isFull()) {
            System.out.println("优先级队列priorityQueue已满！");
        } else {
            j = nItems - 1;
            //选择的排序方法是插入排序，按照从大到小的顺序排列，越小的越在队列的顶端
            while (j >= 0 && value > priQueArray[j]) {
                priQueArray[j + 1] = priQueArray[j];
                j--;
            }
            priQueArray[j + 1] = value;
            nItems++;
        }
    }

    //移除数据，由于是按照大小排序的，所以移除数据时指针向下移动
    //被移除的地方由于是int类型的，不能设置为null，这里的做法是设置为-1；
    public int remove() {
        int k = nItems - 1;
        int value = priQueArray[k];
        //-1表示这个位置的数据被移除了
        priQueArray[k] = -1;
        nItems--;
        return value;
    }

    //查看优先级最高的元素
    public int peekMIn() {
        return priQueArray[nItems - 1];
    }

    //判断是否为空
    public boolean isEmpty() {
        return (nItems == 0);
    }

    //判断队列是否已满
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
