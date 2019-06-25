package com.company.Interview;

/**
 * 要求先打印5个"hello"，后打印5个"world"
 */

public class ThreadTest {

    private Runnable runnable = () -> {
        System.out.println("hello");
        System.out.println("world");
    };

    public void test() throws InterruptedException {
        for (int i = 0; i < 5; i ++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
