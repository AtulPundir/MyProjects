package com.ap.pre.walmart;

import java.util.Stack;

public class BalancedBrackets {

    private static boolean isbalanced2(String str) {
        Stack<Character> stack = new Stack<>();

        if (str== null || str.length() == 0 || !(str.length()%2==0)){
            return false;
        }

       // char[] charArray = new char[str.length()];

        //for (int i =0; i < str.length() ; i++){
        //    charArray[i] = str.charAt(i);
        //}
        for (char ch : str.toCharArray()){
            if (ch =='(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (!stack.isEmpty()) {
                char top = stack.peek();  //char top =  stack.pop();
                if (!((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']'))){
                    return false;
                }
                stack.pop();   // if peek, then required
            }
        }
        return stack.isEmpty() ? true : false;
     }

    public static void main(String[] args) {
       String s ="[({[(())][]})]";
        //String s ="[[";
        boolean res = isbalanced2(s);
        System.out.println(res);

    }

}
