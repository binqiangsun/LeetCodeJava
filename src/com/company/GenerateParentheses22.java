package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbinqiang on 28/06/2017.
 */
public class GenerateParentheses22 {

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


    public static void main(String[] args) {
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        System.out.println(generateParentheses22.generateParenthesis(3));
    }


}
