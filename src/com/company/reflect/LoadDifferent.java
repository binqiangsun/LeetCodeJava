package com.company.reflect;

/**
 * Created by sunbinqiang on 2020/7/23.
 */
public class LoadDifferent {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class r = Class.forName("com.company.reflect.Robot");
        r.getDeclaredMethod("get", String.class);
    }
}
