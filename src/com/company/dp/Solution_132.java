package com.company.dp;

import com.company.Solution_20;

/**
 * Created by sunbinqiang on 13/07/2017.
 * https://leetcode.com/problems/palindrome-partitioning-ii/#/description
 * 思路： dp
 * dp状态： dp[n] 代表字符串0-n子串所需的划分次数
 * dp方程： dp[n] = max(dp[n-1] + 1, dp[j] + 1, ...) j代表 j+1-n的字符串可以组成回文
 *
 * dp状态只记录划分的结果， 运算超时
 * 再开辟一个而为数组， 记录pali[i][j]是否为回文字符串， 如果是， 那么只要c[i-1] == c[j+1] 那么pali[i-1][j+1]也为回文字符串
 * 中间又很多判断是否回文字符串针对同一段子串的判断。
 *
 */
public class Solution_132 {

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] pali = new boolean[s.length()][s.length()];
        int length = s.length();
        dp[0] = 0;

        for (int i = 1; i < length; i ++) {
            int minSub = i;
            for (int j = 0; j < i; j ++) {
                //i-1 < j + 1 || pali[j+1][i-1] 这个表达式代表要么i-1， j+1 只有一个字符或者没有字符， 或者[j+1][i-1]是回文字符串
                if (s.charAt(i) == s.charAt(j) && (i-1 <= j + 1 || pali[j+1][i-1])) {
                    pali[j][i] = true;
                    if (j == 0) {
                        minSub = -1;
                        break;
                    }
                    minSub = (minSub > dp[j - 1]) ? dp[j-1] : minSub;
                }
            }
            dp[i] = Math.min(dp[i - 1], minSub) + 1;
        }
        return dp[length - 1];
    }

    /**
     * 判断是否回文字符串
     * @param str
     * @return
     */
    private boolean isPalindrome(String str) {
        int l = str.length();
        for(int i = 0; i < l / 2; i ++) {
            if (str.charAt(i) != str.charAt(l - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void test() {
        Solution_132 solution_132 = new Solution_132();
        System.out.println(solution_132.minCut("aba"));
    }


}
