package com.ap.pre.leetcode;

import java.util.Stack;

public class A224BasicCalculator {
    public static void main(String[] args) {

        String s = "1 + 1";

        System.out.println(calculate(s));
        
    }


    public static int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
      int num = 0, result = 0, sign = 1;  // sign = 1 for '+', -1 for '-'

      for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);

          if (Character.isDigit(ch)) {
              num = num * 10 + (ch - '0'); // Construct multi-digit numbers
          } else if (ch == '+' || ch == '-') {
              result += sign * num;  // Apply previous number
              num = 0;  // Reset number
              sign = (ch == '+') ? 1 : -1;
          } else if (ch == '(') {
              stack.push(result);  // Save current result
              stack.push(sign);  // Save current sign
              result = 0;  // Reset result for new sub-expression
              sign = 1;  // Default sign
          } else if (ch == ')') {
              result += sign * num;  // Compute inner expression
              num = 0;
              result *= stack.pop();  // Apply sign before '('
              result += stack.pop();  // Add previous result before '('
          }
      }
      
      return result + (sign * num);  // Add last pending number
        
    }

}


/*
 * 
 Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

 */