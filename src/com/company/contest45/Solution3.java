package com.company.contest45;

import com.company.weaklyContest40.Solution_639;

/**
 * Created by sunbinqiang on 13/08/2017.
 */
public class Solution3 {


    public int newInteger(int n) {
        StringBuilder result = new StringBuilder("");
        while (n >= 9) {
            int num = n % 9;
            result.insert(0, num);
            n = n / 9;
        }
        result.insert(0, n);
        return Integer.valueOf(result.toString());
    }

    private int containNine(int i) {
        StringBuilder result = new StringBuilder("");
        while (i >= 9) {
            int num = i % 9;
            result.insert(0, num);
            i = i / 9;
        }
        return Integer.valueOf(result.toString());
    }

    public static void test() {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.newInteger(100000000));
    }
}
