package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbinqiang on 29/07/2017.
 */
public class Solution_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int pow = getPow(n);
        for (int i = 1; i <= 9; i ++) {
            for (int j = 0; j < pow; j ++) {
                result.add(i * (j * 10) );
            }
        }
        return result;
    }

    private int getPow(int num) {
        int res = 1;
        while (num > 0) {
            num = num / 10;
            res ++;
        }
        return res;
    }
}
