package com.company.Interview.thread;

/**
 * Created by sunbinqiang on 2020/6/21.
 */
public class ThreadTest2 {

    public static void attack() {
        System.out.println("Fight");
        System.out.println("Current thread name is " + Thread.currentThread().getName());
    }

    public static void main() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                attack();
            }
        };
        System.out.println("Current main name is " + Thread.currentThread().getName());
        thread.start();
//        thread.run();
    }

}
