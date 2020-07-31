package com.company.Interview.thread;

import java.util.concurrent.Callable;

/**
 * Created by sunbinqiang on 2020/6/21.
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("start");
        Thread.currentThread().sleep(5000);
        return "over----";
    }
}
