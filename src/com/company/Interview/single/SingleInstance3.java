package com.company.Interview.single;

/**
 * Created by sunbinqiang on 2020/6/19.
 */
public class SingleInstance3 {
    private SingleInstance3() {}

    private static SingleInstance3 instance3 = new SingleInstance3();

    public static SingleInstance3 getInstance3() {
        return instance3;
    }
}
