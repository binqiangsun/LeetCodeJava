package com.company.contest46;

/**
 * Created by sunbinqiang on 20/08/2017.
 */
public class Solution_1 {

    public int[][] imageSmoother(int[][] M) {
        int height = M.length;
        int width = M[0].length;
        int[][] result = new int[height][width];
        for (int i = 0 ; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                result[i][j] = getValue(M, i, j, width, height);
            }
        }
        return result;
    }

    private int getValue(int[][] m, int i, int j, int width, int height) {
        int[][] matrix = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int value = 0;
        int count = 0;
        for (int k = 0; k < matrix.length; k ++) {
            if (i + matrix[k][0] >= 0 &&
                    i + matrix[k][0] < height &&
                    j + matrix[k][1] >= 0 &&
                    j + matrix[k][1] < width) {
                value += m[i + matrix[k][0]][j + matrix[k][1]];
                count ++;
            }
        }
        return value / count;
    }
}
