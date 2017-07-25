package com.company.weaklyContest41;

/**
 * Created by sunbinqiang on 16/07/2017.
 */
public class Solution_644 {
    public double findMaxAverage(int[] nums, int k) {
        double[] dp = new double[nums.length];
        double[] value = new double[nums.length];
        double[] sumK = new double[nums.length];

        for (int i = 0; i < k; i ++) {
            value[0] += nums[i];
        }
        dp[0] = value[0] / (double)k;
        sumK[0] = value[0];
        for (int i = 1; i < nums.length - k + 1; i ++) {
            int l = i;
            int r = i + k - 1;
            value[i] = value[i-1] + nums[r] - nums[l-1];
            dp[i] = Math.max(value[i] / (double) (r - l + 1), dp[i-1]);
            l--;
            sumK[i] = value[i];
            //最大的长度大于K的连续平均值
            for (; l >= 0; l --) {
                sumK[l] = sumK[l] + nums[r];
                dp[i] = Math.max(sumK[l] / (double)(r-l+1), dp[i]);
            }
        }
        return dp[nums.length - k];
    }

    public static void test() {
        Solution_644 solution_644 = new Solution_644();
        int[] source = {8,0,1,7,8,6,5,5,6,7};
        System.out.println(solution_644.findMaxAverage(source, 5));
    }
}
