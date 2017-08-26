package com.company.dfs;

/**
 * Created by sunbinqiang on 18/08/2017.
 */
public class Solution_494 {
    public int findTargetSumWays(int[] nums, int S) {
        return findDfs(nums, 0, 0, S, true) +
                findDfs(nums, 0, 0, S, false);
    }

    public int findDfs(int[] nums, int level, int sum, int S, boolean isAdded) {
        if (isAdded) {
            sum += nums[level];
        } else {
            sum -= nums[level];
        }
        if (level == nums.length - 1) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        }
        return findDfs(nums, level + 1, sum, S, true) +
                findDfs(nums, level + 1, sum , S, false);

    }
}
