package com.company.Interview.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by sunbinqiang on 2020/6/21.
 */
public class ThreadDemo {

    public static void main() {
//        MyThread mt1 = new MyThread("thread1");
//        MyThread mt2 = new MyThread("thread2");
//        MyThread mt3 = new MyThread("thread3");
//        Thread mr1 = new Thread(new MyRunnable("runnable1"));
//        Thread mr2 = new Thread(new MyRunnable("runnable2"));
//        Thread mr3 = new Thread(new MyRunnable("runnable3"));
//        mt1.start();
//        mt2.start();
//        mt3.start();
//        mr1.start();
//        mr2.start();
//        mr3.start();

        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");

        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        new Thread(futureTask).start();
        if (!futureTask.isDone()) {
            System.out.println("task is not done");
        }
        try {
            System.out.println("future result: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ThreadPoolDemo.main();
    }

}
