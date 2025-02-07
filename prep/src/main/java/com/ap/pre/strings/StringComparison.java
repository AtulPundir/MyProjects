package com.ap.pre.strings;

public class StringComparison {

    public static void main(String[] args) {
        String str1 = new String("Scaler");
        String str2 = new String("Scaler");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

//intern() usage    
        String str3 = new String("TestIntern").intern();
        String str4 = new String("TestIntern").intern();
        System.out.println(str3 == str4);
    }
}
