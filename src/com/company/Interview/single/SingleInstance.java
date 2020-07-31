package com.company.Interview.single;

/**
 * Created by sunbinqiang on 2020/6/19.
 * 懒汉
 */
public class SingleInstance {

    private static SingleInstance instance;

    private SingleInstance() {}

    public static SingleInstance getInstance() {
        if (instance == null) {
            instance = new SingleInstance();
        }
        return instance;
    }
}

