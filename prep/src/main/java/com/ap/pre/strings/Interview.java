package com.ap.pre.strings;

public class Interview {

    public static String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            
            //if (sb.charAt(i) == ch) {
            //    result.deleteCharAt(i);
            //}

            if (str.charAt(i) != ch) {
                result.append(str.charAt(i));
            } 
        }
        return result.toString();
    }

    public static void main(String[] args) {
        stringbuilderCapacityCheck();
        String s = "Hello world";
        String result = removeCharacter(s, 'o');
        System.out.println(result);
    }

    static void stringbuilderCapacityCheck() {
        // The initial capacity of the string builder is 16 plus the length of the string argument.
        // Default constructor
        StringBuilder sb1 = new StringBuilder();
        System.out.println("Default capacity: " + sb1.capacity()); // 16

        // Constructor with string argument
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("Capacity with 'hello': " + sb2.capacity()); // 16 + 5 = 21

        // Constructor with specified capacity
        StringBuilder sb3 = new StringBuilder(50);
        System.out.println("Specified capacity: " + sb3.capacity()); // 50
    }

}
