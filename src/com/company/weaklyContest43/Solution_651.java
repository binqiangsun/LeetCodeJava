package com.company.weaklyContest43;

/**
 * Created by sunbinqiang on 30/07/2017.
 */
public class Solution_651 {
    public int maxA(int N) {
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i ++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 3; j <= i; j ++) {
                dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
            }
        }
        return dp[N-1];
    }

    public static void test() {
        Solution_651 solution_651 = new Solution_651();
        System.out.println(solution_651.maxA(9));
    }
}
