package com.yf.java.study.thread.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * @Author: YangFei
 * @Description: JAVA中最简单的线程示例之【实现Runnable接口】
 * @create: 2020-01-15 22:40
 */
public class MyDefindRunnable implements Runnable {

    static {
        BasicConfigurator.configure();
    }

    private static final Log LOGGER = LogFactory.getLog(MyDefindRunnable.class);

    @Override
    public void run() {
        //　获取当前线程的ID
        long threadId = Thread.currentThread().getId();
        MyDefindRunnable.LOGGER.info("线程（" + threadId + "）做了一些事情，然后结束了。");
    }

    public static void main(String[] args) {
        new Thread(new MyDefindRunnable()).start();
    }
}
