package com.ap.pre.leetcode.epam;

import java.util.Stack;

public class ValidParenthesis20 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]({[{}][{}]})"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']'){
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();

                if ((top == '(' && c != ')') || (top == '{' && c != '}') || (top == '[' && c != ']')){
                    return false;
                } 
            }

        }
        return stack.isEmpty();
    }

}
