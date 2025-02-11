package com.ap.pre.datastructures.walmart;

public class LongestCommonSubsequence {
    
    // Function to find the length of Longest Common Subsequence
    public static int longestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // dp[i][j] will store the length of LCS of X[0..i-1] and Y[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // If characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take max of excluding one character
                }
            }
        }

        return dp[m][n]; // Length of the LCS is stored in dp[m][n]
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABB";

        System.out.println("Length of Longest Common Subsequence: " + longestCommonSubsequence(X, Y));

    }
}


/*
 * 
Longest Common Subsequence (LCS) Problem:
The Longest Common Subsequence (LCS) problem is a classical problem in computer science, especially in dynamic programming. 
It involves finding the longest subsequence that two strings have in common. 
A subsequence is a sequence derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Problem Statement:
Given two strings X and Y, find the length of the longest subsequence present in both strings.

A subsequence is a sequence that appears in the same relative order but not necessarily consecutively.
Input:
Two strings X and Y of lengths m and n.
Output:
Length of the longest common subsequence between X and Y.



Example 1:
Input:
X = "ABCBDAB"
Y = "BDCABB"
Output:
LCS = 4
Explanation: The longest common subsequence is "BDAB".


Example 2:
Input:
X = "AGGTAB"
Y = "GXTXAYB"

Output:
LCS = 4
Explanation: The longest common subsequence is "GTAB".


Explanation of the Code:
Function longestCommonSubsequence(String X, String Y):
This function takes two strings X and Y and calculates the length of their LCS.
We create a 2D DP array dp with dimensions (m+1) and (n+1) where m is the length of X and n is the length of Y.
We iterate through each character of both strings and update the DP table based on whether characters match or not.

=====Nested Loops:
The outer loop iterates through the string X (of length m), and the inner loop iterates through the string Y (of length n).
If the characters X[i-1] and Y[j-1] are equal, we add 1 to the result from the previous diagonal dp[i-1][j-1].
If they are not equal, we take the maximum value from either excluding the current character of X (dp[i-1][j]) or excluding the current character of Y (dp[i][j-1]).

======Result:
The length of the LCS is stored in dp[m][n], where m and n are the lengths of the strings X and Y.

====Time Complexity:
The time complexity of this solution is O(m * n), where m and n are the lengths of the two input strings. This is because we fill a 2D table of size m+1 by n+1.
Space Complexity:
The space complexity is O(m * n) due to the 2D DP table used to store the results of subproblems.
 * 
 * 
 * 
 */