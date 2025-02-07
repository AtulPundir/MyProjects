package com.ap.pre.strings;

public class ReverseString {
    public static void main(String[] args) {
        String str = "help";
        System.out.println(reverse(str));
        String str2 = "world";
        System.out.println(reverse2(str2)); 
    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static String reverse2(String str) {
        StringBuilder sb = new StringBuilder();
       
        for (int i = str.length()-1; i>=0 ; i--){
            sb.append(str.charAt(i));

        }
        return sb.toString();
    }
}