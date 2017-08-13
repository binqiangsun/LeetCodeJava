package com.company.weaklyContest43;

/**
 * Created by sunbinqiang on 30/07/2017.
 */
public class Solution_650 {
    public int minSteps(int n) {
        int res = 0;

        while (n > 1) {
            int k = n / 2;
            for (int j = k; j >= 2; j --) {
                if (n % j == 0) {
                    int x = n / j;
                    n = j;
                    res += x;
                    continue;
                }
            }
            res += n;
            break;
        }
        return res;
    }

    public static void test(){
        Solution_650 solution_650 = new Solution_650();
        System.out.println(solution_650.minSteps(9));
    }
}
