package com.yf.java.study.thread.pool;

import java.util.concurrent.ThreadFactory;

/**
 * @Author: YangFei
 * @Description: 测试自定义的一个线程工厂
 * @create: 2020-02-07 10:55
 */
public class TestThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        // do something before new thread created;

        // create new thread ， and return
        return new Thread(r);
    }
}
