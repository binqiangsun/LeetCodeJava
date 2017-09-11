package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunbinqiang on 03/09/2017.
 */
public class Solution_670 {
    public int maximumSwap(int num) {
        int first = 0, second = 0;
        boolean find = false;
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int x = num % 10;
            list.add(x);
            num = num / 10;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i ++) {
            int max = list.get(i);
            for (int j = i + 1; j < list.size(); j ++) {
                if (list.get(j) > max || (max != list.get(i) && list.get(j) == max)) {
                    find = true;
                    second = j;
                    max = list.get(j);
                }
            }
            if (find) {
                first = i;
                break;
            }
        }
        if (find) {
            int temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }
        int size = list.size();
        int result = 0;
        for (int i = 0; i < size; i ++) {
            result += (int)Math.pow(10, size - i - 1) * list.get(i);
        }
        return result;
    }

    public static void test() {
        Solution_670 solution_670 = new Solution_670();
        System.out.println(solution_670.maximumSwap(98368));
    }
}
