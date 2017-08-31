package com.company.contest47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunbinqiang on 27/08/2017.
 */
public class Solution_1 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) return false;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int index = -1;
        int i = 0;
        for (i = 0; i < nums.length - 1; i ++) {
            list.add(nums[i]);
            if (nums[i] > nums[i+1]){
                index = i;
            }
        }
        list.add(nums[nums.length - 1]);
        if (index == -1) return true;
        list.remove(index);
        for (int j = 0; j < list.size() - 1; j ++) {
            if (j == index)
                continue;
            if (list.get(j) > list.get(j+1)){
                count = 1;
            }
        }
        return count == 0;
    }
}
