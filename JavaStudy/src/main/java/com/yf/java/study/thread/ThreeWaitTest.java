package com.yf.java.study.thread;

public class ThreeWaitTest {

    public static void main(String[] args) {
        final Outer outer = new Outer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 5; i++) {
                    outer.main(i);
                }
            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                for (int i = 0; i < 5; i++) {
//                    outer.sub1(i);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                for (int i = 0; i < 5; i++) {
//                    outer.sub2(i);
//                }
//            }
//        }).start();

    }

    static class Outer {

        static int flag = 1;

        public synchronized void main(int i) {

            while (flag != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 3; j++) {
                System.out.println("main thread " + (j + 1) + " 次" + " loop of " + (i + 1));
            }

            flag = 2;
            this.notifyAll();

        }

        public synchronized void sub1(int i) {
            while (flag != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 3; j++) {
                System.out.println("sub1 thread " + (j + 1) + " 次" + " loop of " + (i + 1));
            }
            flag = 3;
            this.notifyAll();
        }

        public synchronized void sub2(int i) {
            while (flag != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 3; j++) {
                System.out.println("sub2 thread " + (j + 1) + " 次" + " loop of " + (i + 1));
            }
            flag = 1;
            this.notifyAll();
        }

    }
}