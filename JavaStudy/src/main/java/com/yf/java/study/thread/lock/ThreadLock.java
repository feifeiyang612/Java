package com.yf.java.study.thread.lock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: YangFei
 * @Description: 多线程之【锁的工作过程】
 * @create: 2020-01-15 23:25
 */
public class ThreadLock {

    /**
     * 拿来加锁的对象
     */
    private static final Object WAIT_OBJECT = new Object();
    /**
     * 日志，如果您没有log4j，请使用System.out
     */
    private static final Log LOGGER = LogFactory.getLog(ThreadLock.class);

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 检查'对象锁'状态。
                synchronized (ThreadLock.WAIT_OBJECT) {
                    LOGGER.info("threadA做了一些事情。。。。");
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 检查'对象锁'状态。
                synchronized (ThreadLock.WAIT_OBJECT) {
                    ThreadLock.LOGGER.info("threadB做了另一些事情。。。。");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
