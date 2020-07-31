package com.company.Interview.thread;

/**
 * Created by sunbinqiang on 2020/6/21.
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++) {
            System.out.print("thread: " + this.name + " " + i);
        }
    }
}
