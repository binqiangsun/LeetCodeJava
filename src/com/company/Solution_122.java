package com.company;

/**
 * Created by sunbinqiang on 24/07/2017.
 * 股票最大收益， 无限次买卖
 * dp方程：
 * dp[i][j] : 收益 i代表天数， j代表持股与否， 0，空仓， 1，持股
 */
public class Solution_122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0-prices[0];
        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

}
