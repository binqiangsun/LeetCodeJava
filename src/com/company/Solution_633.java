package com.company;

/**
 * Created by sunbinqiang on 02/07/2017.
 */
public class Solution_633 {
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c) + 1;
        int a = 0, b;
        for (; a < max; a ++) {
            if (a * a > c) {
                break;
            }
            if (a * a == c) {
                return true;
            }
            b = (int) Math.sqrt(c - a*a) - 1;
            int bMax = (int) Math.sqrt(c - a*a) + 1;
            for (; b < bMax; b ++) {
                if (a * a + b * b > c) {
                    break;
                } else if (a * a + b * b == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void test() {
        Solution_633 solution_633 = new Solution_633();
        System.out.println(solution_633.judgeSquareSum(5));
        System.out.println(solution_633.judgeSquareSum(6));
        System.out.println(solution_633.judgeSquareSum(9));
        System.out.println(solution_633.judgeSquareSum(2147483644));
    }
}
