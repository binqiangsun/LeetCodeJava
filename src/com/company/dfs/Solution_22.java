package com.company.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbinqiang on 28/06/2017.
 * 利用左右括号合成正确的表达式
 * DFS
 * 递归
 * 左右括号的条件
 */
public class Solution_22 {

    private List<String> result;

    public List<String> generateParenthesis(int n) {

        result = new ArrayList<>();
        if (n <= 0) return result;

        generate(0, 0, 0, n * 2, "");

        return result;
    }

    private void generate(int level, int left, int right, int n, String curString) {
        if (level >= n) {
            result.add(curString);
            return;
        }

        if (left < n / 2) {
            generate(level + 1, left + 1, right, n, curString + "(");
        }

        if (right < n / 2 && left > right) {
            generate(level + 1, left, right + 1, n, curString + ")");
        }
    }

    public static void test() {
        Solution_22 generateParentheses22 = new Solution_22();
        System.out.println(generateParentheses22.generateParenthesis(3));
    }
}
