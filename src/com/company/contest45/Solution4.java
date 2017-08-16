package com.company.contest45;

import com.company.weaklyContest40.Solution_640;


/**
 * Created by sunbinqiang on 13/08/2017.
 */
public class Solution4 {

    public boolean isPossible(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int[] counts = new int[nums[nums.length-1] - nums[0] + 1];
        int start = nums[0];
        counts[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            counts[nums[i] - start] ++;
        }
        start = 0;
        int consecu;
        while (true) {
            consecu = 0;
            for (int i = start; i < counts.length; i ++) {
                if (i == start) {
                    counts[i] --;
                    consecu ++;
                    if (counts[i] == 0) {
                        start = -1;
                    }
                    continue;
                }
                if (counts[i] > counts[i-1]) {
                    counts[i] --;
                    consecu++;
                    if (counts[i] != 0 && start == -1) {
                        start = i;
                    }
                } else {
                    break;
                }
            }
            if (consecu < 3) {
                return false;
            }
            if (start == -1) {
                return true;
            }
        }
    }

    public static void test() {
        Solution4 solution4 = new Solution4();
        int[] nums = {1,2,3,4,4,5};
        System.out.println(solution4.isPossible(nums));
    }

}
