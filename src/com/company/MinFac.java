package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunbinqiang on 18/06/2017.
 */
public class MinFac {

    public int smallestFactorization(int a) {
        if (a == 1) {
            return 1;
        }
        if (a > Integer.MAX_VALUE || a < 1) {
            return 0;
        }
        Stack<Integer> resList = new Stack<>();
        getMaxFac(a, resList);
        return getIntByList(resList);
    }

    private boolean getMaxFac(int b, Stack<Integer> resList) {
        if (b == 1) return true;
        int i = 9;
        for (; i > 1; i --) {
            if (b % i == 0) {
                resList.push(i);
                if (!getMaxFac(b / i, resList)) {
                    resList.pop();
                    return false;
                }
                break;
            }
        }
        return i != 1;

    }

    private int getIntByList(List<Integer> resList) {
        int res = 0;
        int pow = 0;
        for (Integer num : resList) {
            double val = num * Math.pow(10, pow++) + res;
            if (val > Integer.MAX_VALUE) {
                return 0;
            }
            res = (int)val;
        }
        return res;
    }
}
