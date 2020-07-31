package com.company.Interview.thread;

/**
 * Created by sunbinqiang on 2020/6/21.
 */
public class WaitDemo {


    public static void main() {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread A get lock");
                    System.out.println("thread A sleep start");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread A sleep done");
                    System.out.println("thread A wait start");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread A wait done");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    System.out.println("thread B sleep start");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread B sleep done");
                    System.out.println("thread B notify start");
                    lock.notify();
                    System.out.println("thread B notify done");

                    System.out.println("thread B sleep start");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread B sleep done");
                }
            }
        }).start();

    }
}
