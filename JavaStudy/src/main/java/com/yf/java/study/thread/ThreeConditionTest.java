package com.yf.java.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeConditionTest {


    public static void main(String[] args) {
        final Outer outer = new Outer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 10; i++) {
                    outer.main(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 10; i++) {
                    outer.sub1(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 10; i++) {
                    outer.sub2(i);
                }
            }
        }).start();

    }

    static class Outer {
        Lock lock = new ReentrantLock();
        Condition mainCondition = lock.newCondition();
        Condition sub1Condition = lock.newCondition();
        Condition sub2Condition = lock.newCondition();
        int flag = 1;

        public void main(int i) {
            lock.lock();
            try {
                if (flag != 1) {
                    try {
                        mainCondition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for (int j = 0; j < 3; j++) {
                    System.out.println("main thread " + (j + 1) + " 次" + " loop of " + (i + 1));
                }
                flag = 2;
                sub1Condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void sub1(int i) {
            lock.lock();
            try {
                if (flag != 2) {
                    try {
                        sub1Condition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for (int j = 0; j < 3; j++) {
                    System.out.println("sub1 thread " + (j + 1) + " 次" + " loop of " + (i + 1));
                }
                flag = 3;
                sub2Condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void sub2(int i) {
            lock.lock();
            try {
                if (flag != 3) {
                    try {
                        sub2Condition.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for (int j = 0; j < 3; j++) {
                    System.out.println("sub2 thread " + (j + 1) + " 次" + " loop of " + (i + 1));
                }
                flag = 1;
                mainCondition.signal();
            } finally {
                lock.unlock();
            }
        }

    }
}