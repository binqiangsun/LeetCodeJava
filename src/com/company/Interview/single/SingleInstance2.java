package com.company.Interview.single;

/**
 * Created by sunbinqiang on 2020/6/19.
 */
public class SingleInstance2 {

    private static SingleInstance2 instance2;

    private SingleInstance2() {}

    public static SingleInstance2 getInstance2() {
        if (instance2 == null) {
            synchronized (SingleInstance2.class) {
                if (instance2 == null) {
                    instance2 = new SingleInstance2();
                }
            }
        }
        return instance2;
    }
}
