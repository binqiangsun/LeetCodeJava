package com.company.weaklyContest41;

/**
 * Created by sunbinqiang on 16/07/2017.
 */
public class Solution_643 {
    public double findMaxAverage(int[] nums, int k) {

        double result = Integer.MIN_VALUE;
        double[] dp = new double[nums.length];
        int n = nums.length;
        for (int i = 0; i < k; i ++) {
            dp[0] += nums[i];
        }
        result = dp[0];
        for (int i = 1; i < n - k + 1; i ++) {
            dp[i] = dp[i-1] - nums[i-1] + nums[i + k-1];
            result = Math.max(dp[i], result);
        }
        return result / (double)k;
    }

    public static void test() {
        Solution_643 solution_643 = new Solution_643();
        int[] source = {1,12,-5,-6,50,3};
        System.out.println(solution_643.findMaxAverage(source, 4));
    }
}
