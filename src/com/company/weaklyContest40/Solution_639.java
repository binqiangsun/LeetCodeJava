package com.company.weaklyContest40;

import java.math.BigInteger;

/**
 * Created by sunbinqiang on 09/07/2017.
 */
public class Solution_639 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        long[] dp = new long[2];
        dp[0] = decodeChar(s.charAt(0));
        if (length == 1 || dp[0] == 0) {
            return (int)dp[0];
        }
        dp[1] = decodeTwoChar(s.charAt(0), s.charAt(1));

        int i = 2;
        for (; i < length; i++) {
            dp[i%2] = ((dp[(i+1)%2] * decodeChar(s.charAt(i)))
                     + (dp[i%2] * decodeTwoChar2(s.charAt(i - 1), s.charAt(i)))) % 1000000007;
        }
        return (int)dp[(length - 1)%2];
    }

    private int decodeTwoChar(char first, char second) {
        if (first == '*') {
            if (second == '*') {
                return 96;
            } else if (second >= '1' && second <= '6') {
                return 11;
            } else if (second == '0') {
                return 2;
            } else {
                return 10;
            }
        } else {
            if (second == '*') {
                if (first == '1') {
                    return 18;
                } else if (first == '2') {
                    return 15;
                } else {
                    return 9;
                }
            } else if (second == '0') {
                if (first == '1' || first == '2') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (first == '1' || (first == '2' && second <= '6')) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
    }

    /**
     * 只返回两个字符合成一个字母的情况
     *
     * @param first
     * @param second
     * @return
     */
    private int decodeTwoChar2(char first, char second) {
        if (first == '*') {
            if (second == '*') {
                return 15;
            } else if (second >= '0' && second <= '6') {
                return 2;
            } else {
                return 1;
            }
        } else {
            if (second == '*') {
                if (first == '1') {
                    return 9;
                } else if (first == '2') {
                    return 6;
                } else {
                    return 0;
                }
            } else {
                if (first == '1' || (first == '2' && second <= '6')) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private int decodeChar(char c) {
        if (c == '*') {
            return 9;
        } else if (c == '0') {
            return 0;
        }
        return 1;
    }


    public static void test() {
        Solution_639 solution_639 = new Solution_639();
        String value = "**********1130111111";
        System.out.println(solution_639.numDecodings(value));
    }


}
