package com.yf.java.study.thread.join;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * @Author: YangFei
 * @Description: 这个线程用来测试join的执行
 * @create: 2020-02-03 16:55
 */
public class JoinThread implements Runnable {

    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(JoinThread.class);

    public static void main(String[] args) {
        /*
         * 启动一个子线程joinThread，然后等待子线程joinThread运行完成后
         * 这个线程再继续运行
         * */
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        Thread joinThread = new Thread(new JoinThread());
        joinThread.start();

        try {
            // 等待，直到joinThread执行完成后，main线程才继续执行
            joinThread.join(100,111);
            JoinThread.LOGGER.info("线程" + id + "继续执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        JoinThread.LOGGER.info("线程" + id + "启动成功，准备进入等待状态（5秒）");

        // 使用sleep方法，模拟这个线程执行业务代码的过程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }
        //执行到这里，说明线程被唤醒了
        JoinThread.LOGGER.info("线程" + id + "执行完成！");
    }
}
