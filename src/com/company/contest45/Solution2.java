package com.company.contest45;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbinqiang on 13/08/2017.
 */
public class Solution2 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.size() == 0) {
            return result;
        }
        int length = arr.size();
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < length; i ++) {
            if (min > Math.abs(arr.get(i) - x)) {
                minIndex = i;
            }
        }
        result.add(arr.get(minIndex));
        int i = minIndex-1, j = minIndex+1;
        while (i > -1 && j < length && j - i - 1 < k) {
            if (Math.abs(arr.get(i) - x) <= Math.abs(arr.get(j) - x)) {
                result.add(0, arr.get(i));
                i --;
            } else {
                result.add(arr.get(j));
                j ++;
            }
        }
        if (j-i-1 >= k) {
            return result;
        } else if (i == -1) {
            for (int m = j; m < k && m < length; m ++) {
                result.add(arr.get(m));
            }
        } else if (j == length) {
            for (int m = i; m > length-k ; m --) {
                result.add(0, arr.get(m));
            }
        }
        return result;
    }
}
