package com.company.dfs;

/**
 * Created by sunbinqiang on 03/08/2017.
 */
public class Solution_547 {

    private boolean[] visited;

    public int findCircleNum(int[][] M) {
        int result = 0;
        visited = new boolean[M.length];

        for (int i = 0; i < M.length; i ++) {
            if (!visited[i]) {
                result ++;
                dfs(M, i);
            }
        }

        return result;
    }

    private void dfs(int[][] M, int x) {
        visited[x] = true;
        for (int i = 0; i < M.length; i ++) {
            if (x != i && M[x][i] == 1 && !visited[i]) {
                dfs(M, i);
            }
        }
    }

}
