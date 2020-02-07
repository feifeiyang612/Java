package com.yf.java.study.thread.pool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YangFei
 * @Description: 线程池的基本使用方式，ThreadPoolExecutor类的最简单使用方式
 * @create: 2020-02-06 11:57
 */
public class PoolThreadSimple {

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) throws InterruptedException {
        /*
         * corePoolSize：表示核心线程池的大小。当提交一个任务时，
         * 如果当前核心线程池的线程个数没有达到corePoolSize，则会创建新的线程来执行所提交的任务，
         * 即使当前核心线程池有空闲的线程。如果当前核心线程池的线程个数已经达到了corePoolSize，
         * 则不再重新创建线程。如果调用了prestartCoreThread()或者 prestartAllCoreThreads()，
         * 线程池创建的时候所有的核心线程都会被创建并且启动。
         *
         * maximumPoolSize：表示线程池能创建线程的最大个数。如果当阻塞队列已满时，
         * 并且当前线程池线程个数没有超过maximumPoolSize的话，就会创建新的线程来执行任务。
         *
         * keepAliveTime：空闲线程存活时间。如果当前线程池的线程个数已经超过了corePoolSize，
         * 并且线程空闲时间超过了keepAliveTime的话，就会将这些空闲线程销毁，这样可以尽可能降低系统资源消耗。
         *
         * unit：时间单位，为keepAliveTime指定时间单位。
         *
         * workQueue：阻塞队列。用于保存任务的阻塞队列，
         * 可以使用ArrayBlockingQueue, LinkedBlockingQueue, SynchronousQueue, PriorityBlockingQueue
         *
         * threadFactory：创建线程的工程类。可以通过指定线程工厂为每个创建出来的线程设置更有意义的名字，
         * 如果出现并发问题，也方便查找问题原因。
         *
         * handler：饱和策略。当线程池的阻塞队列已满和指定的线程都已经开启，
         * 说明当前线程池已经处于饱和状态了，那么就需要采用一种策略来处理这种情况。采用的策略有这几种：
         * 1、AbortPolicy： 直接拒绝所提交的任务，并抛出RejectedExecutionException异常；
         * 2、CallerRunsPolicy：只用调用者所在的线程来执行任务；
         * 3、DiscardPolicy：不处理直接丢弃掉任务；
         * 4、DiscardOldestPolicy：丢弃掉阻塞队列中存放时间最久的任务，执行当前任务
         * */

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>()
        );
//        poolExecutor.allowCoreThreadTimeOut(true);
        for (int index = 0; index < 10; index++) {
            poolExecutor.submit(new PoolThreadSimple.TestRunnable(index));
        }
        // 没有特殊含义，只是为了保证main线程不会退出
        synchronized (poolExecutor) {
            poolExecutor.wait();
        }
    }

    /**
     * @Author yangfei
     * @Description 这个就是测试用的线程
     * @Date 23:59 2020/2/6
     **/
    private static class TestRunnable implements Runnable {

        private static Log LOGGER = LogFactory.getLog(TestRunnable.class);

        // 记录任务的唯一编号，这样在日志中好做识别
        private Integer index;

        public TestRunnable(int index) {
            this.index = index;
        }

        public Integer getIndex() {
            return index;
        }

        @Override
        public void run() {
            /*
             * 线程中，就只做一件事情：
             * 等待60秒钟的事件，以便模拟业务操作过程
             * */
            Thread currentThread = Thread.currentThread();
            long id = currentThread.getId();
            TestRunnable.LOGGER.info("线程：" + id + " 中的任务（" + this.getIndex() + "）开始执行===");
            synchronized (currentThread) {
                try {
                    currentThread.wait(6000);
                } catch (InterruptedException e) {
                    TestRunnable.LOGGER.error(e);
                }
            }
            TestRunnable.LOGGER.info("线程：" + id + " 中的任务（" + this.getIndex() + "）执行完成");
        }
    }
}
