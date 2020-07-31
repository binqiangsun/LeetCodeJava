package com.company.Interview.thread;

/**
 * Created by sunbinqiang on 2020/6/21.
 */
public class CycleWait implements Runnable {

    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";

    }
}
