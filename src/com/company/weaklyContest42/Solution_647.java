package com.company.weaklyContest42;

/**
 * Created by sunbinqiang on 23/07/2017.
 */
public class Solution_647 {
    public int countSubstrings(String s) {
        int res = s.length();
        for (int i = 0; i < s.length(); i ++) {
            //奇数
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                res ++;
                j--;
                k++;
            }

            //偶数
            j = i;
            k = i+1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                res ++;
                j--;
                k++;
            }
        }

        return res;
    }

    public static void test() {
        Solution_647 solution_647 = new Solution_647();
        System.out.println(solution_647.countSubstrings("aba"));
        System.out.println(solution_647.countSubstrings("aaa"));
    }
}
