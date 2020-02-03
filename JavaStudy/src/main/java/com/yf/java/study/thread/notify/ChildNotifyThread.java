package com.yf.java.study.thread.notify;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: YangFei
 * @Description: 用来在启动后，等待唤醒
 * @create: 2020-02-02 23:34
 */
public class ChildNotifyThread implements Runnable {

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(ChildNotifyThread.class);

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        long id = currentThread.getId();
        ChildNotifyThread.LOGGER.info("线程" + id + "启动成功，准备进入等待状态");
        synchronized (ParentNotifyThread.WAIT_CHILEOBJECT) {
            try {
                ParentNotifyThread.WAIT_CHILEOBJECT.wait();
            } catch (InterruptedException e) {
                ChildNotifyThread.LOGGER.error(e.getMessage(), e);
            }
        }
        //执行到这里，说明线程被唤醒了
        ChildNotifyThread.LOGGER.info("线程" + id + "被唤醒！");
    }
}
