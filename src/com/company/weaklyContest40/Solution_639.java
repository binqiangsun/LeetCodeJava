package com.company.weaklyContest40;

/**
 * Created by sunbinqiang on 09/07/2017.
 * 动态规划
 * 递推的方程是： dp[i] = dp[i-1]*decodeChar(s.charAt(i)) + dp[i-2]*decodeTwoChar(s.charAt(i-1), s.charAt(i)
 * 1， 重点是两个数字合成一个字母的情况， 见函数： decodeTwoChars；
 * 2， 题目要求结果输出是10^9 + 7 的余数， 而每次结果都是前两次结果的乘积方式， 所以每次结果都输出余数即可。
 */
public class Solution_639 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        long[] dp = new long[2];
        dp[0] = decodeChar(s.charAt(0));
        dp[1] = 1;

        for (int i = 1; i < length; i++) {
            dp[i % 2] = (dp[(i + 1) % 2] * decodeChar(s.charAt(i)))
                    + (dp[i % 2] * decodeTwoChars(s.charAt(i - 1), s.charAt(i)));
            dp[i % 2] = dp[i % 2] % 1000000007;
        }
        return (int) dp[(length - 1) % 2];
    }

    private int decodeChar(char c) {
        if (c == '*') {
            return 9;
        } else if (c == '0') {
            return 0;
        }
        return 1;
    }

    /**
     * 返回两个字符合成一个字母的情况
     *
     * @param first
     * @param second
     * @return
     */
    private int decodeTwoChars(char first, char second) {
        switch (first) {
            case '*':
                if (second == '*') {
                    return 15;
                } else if (second >= '0' && second <= '6') {
                    return 2;
                } else {
                    return 1;
                }
            case '1':
                if (second == '*') {
                    return 9;
                } else {
                    return 1;
                }
            case '2':
                if (second == '*') {
                    return 6;
                } else if (second >= '0' && second <= '6') {
                    return 1;
                } else {
                    return 0;
                }
            default:
                return 0;
        }
    }


    public static void test() {
        Solution_639 solution_639 = new Solution_639();
        String value = "**";
        System.out.println(solution_639.numDecodings(value));
    }


}
