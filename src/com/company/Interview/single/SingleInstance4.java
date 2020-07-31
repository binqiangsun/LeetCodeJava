package com.company.Interview.single;
/**
 * Created by sunbinqiang on 2020/6/19.
 */
public class SingleInstance4 {

    private SingleInstance4() {}
    private static class SingleInstanceHolder {
        private static final SingleInstance4 instance = new SingleInstance4();
    }

    public static SingleInstance4 getInstance() {
        return SingleInstanceHolder.instance;
    }
}
