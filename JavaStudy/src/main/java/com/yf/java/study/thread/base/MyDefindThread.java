package com.yf.java.study.thread.base;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * @Author: YangFei
 * @Description: JAVA中最简单的线程示例之【继承Thread父类】
 * @create: 2020-01-15 22:23
 */
public class MyDefindThread extends Thread {

    static {
        BasicConfigurator.configure();
    }

    private static final Log LOGGER = LogFactory.getLog(MyDefindThread.class);

    @Override
    public void run() {
        Long threadId = this.getId();
        MyDefindThread.LOGGER.info("线程（" + threadId + "）做了一些事情，然后结束了。");
    }

    public static void main(String[] args) {
//        new MyDefindThread().start();
//        new MyDefindThread().start();
        new MyDefindThread().start();
    }
}
