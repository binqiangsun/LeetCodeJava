package com.company;

import java.util.Stack;

/**
 * Created by sunbinqiang on 12/05/2017.
 */
public class ValidParentheses {

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
