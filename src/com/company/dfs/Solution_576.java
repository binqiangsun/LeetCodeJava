package com.company.dfs;

/**
 * Created by sunbinqiang on 12/07/2017.
 * https://leetcode.com/problems/out-of-boundary-paths/#/description
 * DFS : 超时
 *
 * DP
 * dp状态： dp[N][i][j] 代表N次内， 在i， j初始状态可能的情况；
 * dp方程： dp[N][i][j] = dp[N-1][i-1][j] + dp[N-1][i+1][j] + dp[N-1][i][j-1] + dp[N-1][i][j+1]
 * 在i， j位置再走一步(只能往上下左右四个方向)， 剩下的步数就是N-1， 四个方向的情况相加就是i， j的情况
 * 需要判断边界值
 */
public class Solution_576 {
    int totalPaths;
    static long dps = 0;
    public int findPaths(int m, int n, int N, int i, int j) {
        totalPaths = 0;
        return dpPaths(m, n, N, i, j);
        //return totalPaths % 1000000007;
    }

    private void dfsPaths(int m, int n, int N, int i, int j, int times) {
        if (times > N) {
            return;
        }

        if (i >= m || j >= n || i < 0 || j < 0) {
            totalPaths ++;
            return;
        }
        //最短路径不能到达， 则退出
        int leftTimes = N - times;
        if (leftTimes < m-i && leftTimes < i + 1 && leftTimes < n - j && leftTimes < j + 1) {
            return;
        }
        //left
        dfsPaths(m, n, N, i - 1, j, times + 1);
        dfsPaths(m, n, N, i + 1, j, times + 1);
        dfsPaths(m, n, N, i, j - 1, times + 1);
        dfsPaths(m, n, N, i, j + 1, times + 1);
    }

    private int dpPaths(int m, int n, int N, int i, int j) {
        if (N == 0) return 0;
        int[][][] dp = new int[N+1][m][n];
        for (int Ni = 1; Ni <= N; Ni ++) {
            for (int mi = 0; mi < m; mi ++) {
                for (int ni = 0; ni < n; ni ++) {
                    dp[Ni][mi][ni]
                            = ((mi - 1 < 0 ? 1 : dp[Ni-1][mi-1][ni])
                            + (mi + 1 >= m ? 1 : dp[Ni-1][mi+1][ni])
                            + (ni - 1 < 0 ? 1 : dp[Ni-1][mi][ni-1])
                            + (ni + 1 >= n ? 1 : dp[Ni-1][mi][ni+1])) % 1000000007;
                }
            }
        }
        return dp[N][i][j];
    }

    public static void test() {
        Solution_576 solution_576 = new Solution_576();
        System.out.println(solution_576.findPaths(2, 2, 2, 0, 0));
        long start = System.currentTimeMillis();
        System.out.println(solution_576.findPaths(8, 7, 16, 1, 5));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(dps);
    }
}
