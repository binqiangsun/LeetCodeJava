package com.company.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunbinqiang on 2020/7/20.
 */
public class ReenterLockDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            if (lock.isLocked()) {
                System.out.println(Thread.currentThread().getName() + " check: is  " + lock.getHoldCount());
            }
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock");
        }

    }


}
