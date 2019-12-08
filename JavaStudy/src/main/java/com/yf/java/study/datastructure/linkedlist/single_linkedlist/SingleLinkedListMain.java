package com.yf.java.study.datastructure.linkedlist.single_linkedlist;

/**
 * @Author: YangFei
 * @Description:
 * @create: 2019-12-06 23:19
 */
public class SingleLinkedListMain {

    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("A");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
    }
}
