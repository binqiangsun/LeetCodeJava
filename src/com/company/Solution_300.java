package com.company;

/**
 * Created by sunbinqiang on 06/07/2017.
 */
public class Solution_300 {
    /**
     * DP[i] : 状态的定义， 从0到i节点(一定要包含i节点)的最长上升子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        int res = 1;

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i ++) {
            dp[i] = 1;
            //状态转移方程
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void test() {
        int[] test = {4, 5, 2, 3};
        Solution_300 solution_300 = new Solution_300();
        System.out.println(solution_300.lengthOfLIS(test));
    }
}
