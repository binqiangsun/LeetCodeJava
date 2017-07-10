package com.company.weaklyContest40;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunbinqiang on 09/07/2017.
 * 字符串操作， 利用队列存储值的字符
 */
public class Solution_640 {

    public String solveEquation(String equation) {

        if (equation == null || equation.length() == 0) {
            return "No solution";
        }
        Queue<Character> queue = new LinkedList<>();
        int right = 1;
        int isBack = 1;
        int x = 0, v = 0;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            switch (c) {
                case '=':
                    v += getV(queue, isBack * right * (-1));
                    right = -1;
                    isBack = 1;
                    break;
                case 'x':
                    if (queue.isEmpty()) {
                        queue.add('1');
                    }
                    x += getV(queue, isBack * right);
                    isBack = 1;
                    break;
                case '+':
                    v += getV(queue, isBack * right * (-1));
                    isBack = 1;
                    break;
                case '-':

                    v += getV(queue, isBack * right * (-1));
                    isBack = -1;
                    break;
                case ' ':
                    break;
                default:
                    queue.add(c);
            }
        }
        v += getV(queue, isBack * right * (-1));
        if (x == 0) {
            if (v != 0) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        }
        int res = v / x;

        return "x=" + String.valueOf(res);

    }

    private int getV(Queue<Character> queue, int isBack) {
        if (queue.isEmpty()) {
            return 0;
        }
        StringBuilder res = new StringBuilder("");
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
        }
        return Integer.valueOf(res.toString()) * isBack;
    }

    public static void test() {
        Solution_640 solution_640 = new Solution_640();
        System.out.println(solution_640.solveEquation("x+5-3+x=6+x-2"));
    }

}
