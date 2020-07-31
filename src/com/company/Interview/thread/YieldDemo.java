package com.company.Interview.thread;

/**
 * Created by sunbinqiang on 2020/6/22.
 */
public class YieldDemo {

    public static void main() {
        Runnable yieldTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i ++) {
                    System.out.println(Thread.currentThread().getName() + i);
                    if (i % 2 == 0) {
                        Thread.yield();
                    }
                }
            }
        };

        Thread t1 = new Thread(yieldTask, "A");
        Thread t2 = new Thread(yieldTask, "B");
        t1.getState();
        t1.start();
        t2.start();
    }
}
