package com.company.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunbinqiang on 16/08/2017.
 * BFS 解法
 * 从0的位置， 开始向周围扩散
 * 如果准备赋值大于原先的值， 则跳过（说明已经有更近的0对其进行赋值过）
 */
public class Solution_542 {

    public int[][] updateMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = height == 0 ? 0 : matrix[0].length;
        int[][] result = new int[height][width];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                if (x - 1 >= 0 && result[x - 1][y] > result[x][y]) {
                    result[x - 1][y] = result[x][y] + 1;
                    queue.add(new int[]{x - 1, y});
                }
                if (y - 1 >= 0 && result[x][y - 1] > result[x][y]) {
                    result[x][y - 1] = result[x][y] + 1;
                    queue.add(new int[]{x, y - 1});
                }
                if (x + 1 < height && result[x + 1][y] > result[x][y]) {
                    result[x + 1][y] = result[x][y] + 1;
                    queue.add(new int[]{x + 1, y});
                }
                if (y + 1 < width && result[x][y + 1] > result[x][y]) {
                    result[x][y + 1] = result[x][y] + 1;
                    queue.add(new int[]{x, y + 1});
                }
            }
        }

        return result;
    }

//    private int dfs(int[][] matrix, boolean[][] visited, int width, int height, int i, int j) {
//        if (i < 0 || j < 0 || i >= width || j >= height) {
//            return Integer.MAX_VALUE / 2;
//        }
//
//        if (matrix[i][j] == 0) {
//            return 0;
//        }
//
//        if (i - 1 >= 0 && !visited[i - 1][j]) {
//
//        }
//        int rowMax = Math.min(dfs(matrix, width, height, i - 1, j), dfs(matrix, width, height, i + 1, j));
//        int columnMax = Math.min(dfs(matrix, width, height, i, j - 1), dfs(matrix, width, height, i, j + 1));
//        return Math.min(rowMax, columnMax) + 1;
//    }

    public static void test() {
        Solution_542 solution_542 = new Solution_542();
        int[][] matrix = {{0}, {0}, {1}};
        solution_542.updateMatrix(matrix);
    }
}
