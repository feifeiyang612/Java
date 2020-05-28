package com.yf.java.study.thread.yield;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * @Author: YangFei
 * @Description: Synchronized关键字的使用
 * @create: 2020-01-17 23:14
 */
public class SyncThread implements Runnable {

    private static final Log LOGGER = LogFactory.getLog(SyncThread.class);

    private Integer value;

    private static Integer NOWVALUE;

    static {
        BasicConfigurator.configure();
    }

    public SyncThread(int value) {
        this.value = value;
    }

    /**
     * 对这个类的实例化对象进行检查
     */
//    private synchronized void doOtherthing() {
//        NOWVALUE = this.value;
//        LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
//    }

    /**
     * 进行SyncThread类的多个实例对象进行同步检查,需要对SyncThread类的class对象进行同步检查
     */
    private void doOtherthing() {
        synchronized (SyncThread.class) {
            NOWVALUE = this.value;
            LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
        }
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        Long id = thread.getId();
        this.doOtherthing();
    }

    public static void main(String[] args) {
        //实例对象1
        SyncThread syncThread_1 = new SyncThread(10);
        //实例对象2
        SyncThread syncThread_2 = new SyncThread(100);

        //线程1
        Thread thread_1 = new Thread(syncThread_1);
        //线程2
        Thread thread_2 = new Thread(syncThread_2);

        thread_1.start();
        thread_2.start();
    }
}
