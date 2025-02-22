package com.ap.pre.leetcode;

//Easy
public class A1768MergeStringsAlternately {
    //0ms self
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int l1 = word1.length();
        int l2 = word2.length();

        int small = l1 < l2 ? l1 : l2;

        int index1 =0,index2 =0;
        
        //Merging Alternately
        for (int i =0; i < small; i++){
            sb.append(word1.charAt(index1));
            sb.append(word2.charAt(index2));
            index1++;
            index2++;
        }
        
         //Merging Remaining string
        if (index1 < l1) sb.append(word1.substring(index1, l1));        
        if (index2 < l2) sb.append(word2.substring(index2, l2));        
        
        return sb.toString();
        
    }

    public static void main(String[] args) {

        String word1 = "a   b   c";

        String word2 = " p   q   r";

        System.out.println(mergeAlternately(word1,word2));
        
    }

}

/* 
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d */

