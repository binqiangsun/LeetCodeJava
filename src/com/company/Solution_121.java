package com.company;

/**
 * Created by sunbinqiang on 24/07/2017.
 * 买卖股票，最大利润， 只能一次买卖
 * 简单做法： 循环每一个值，与之前的最小值比较，保留最大的利润
 */
public class Solution_121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minVal = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            }
            int profit = prices[i] - minVal;
            if (profit > res) {
                res = profit;
            }
        }
        return res;
    }
}
