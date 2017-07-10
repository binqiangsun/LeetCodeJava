package com.company;

import java.util.Stack;

/**
 * Created by sunbinqiang on 12/05/2017.
 * 判断括号是否合法
 * stack 结构
 */
public class Solution_20 {

    public static boolean validParentheses(String s){
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' ) {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
