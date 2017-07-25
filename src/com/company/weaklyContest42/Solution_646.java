package com.company.weaklyContest42;


import java.util.*;

/**
 * Created by sunbinqiang on 23/07/2017.
 * 在dp之前，先根据第二个值从小到大排序
 * last last[i] 代表链条最后一个的index
 * dp dp[i]    代表0-i之间最长的链条节点数
 */
public class Solution_646 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int[] dp = new int[pairs.length];
        int[] last = new int[pairs.length];
        dp[0] = 1;
        last[0] = 0;
        for (int i = 1; i < pairs.length; i ++) {
            last[i] = pairs[i][0] > pairs[last[i-1]][1] ? i : last[i-1];
            dp[i] = dp[last[i-1]] + ((pairs[i][0] > pairs[last[i-1]][1]) ? 1 : 0);
        }
        return dp[pairs.length-1];
    }

    public static void test() {
        Solution_646 solution_646 = new Solution_646();
        int[][] pairs1 = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        int[][] pairs2 = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        System.out.println(solution_646.findLongestChain(pairs1));
        System.out.println(solution_646.findLongestChain(pairs2));
    }
}
