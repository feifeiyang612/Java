package com.yf.java.study.datastructure.queue.priority_queue;

/**
 * @Author: YangFei
 * @Description:
 * @create: 2019-12-06 17:18
 */
public class PriorityQueueMain {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(3);
        priorityQueue.insert(4);
        priorityQueue.insert(5);
        //查看队列中优先级最高的元素
        System.out.println(priorityQueue.peekMIn());
        //查看队列是否已满
        System.out.println(priorityQueue.isFull());
        priorityQueue.remove();
        priorityQueue.insert(7);
        priorityQueue.insert(8);
    }
}
