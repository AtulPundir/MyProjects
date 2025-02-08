package com.ap.pre.walmart;

public class RodCutting {
    
    // Function to find the maximum profit
    public static int cutRod(int[] prices, int n) {
        // Create a DP array to store maximum profit for each length of rod
        int[] arr = new int[n + 1];
        
        // Build the dp array in bottom-up manner
        for (int i = 1; i <= n; i++) {
            int maxProfit = Integer.MIN_VALUE;
            // Try all possible cuts for the rod of length i
            for (int j = 1; j <= i; j++) {
                maxProfit = Math.max(maxProfit, prices[j - 1] + arr[i - j]);
            }
            arr[i] = maxProfit;
        }
        
        return arr[n]; // Maximum profit for the rod of length n
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20}; // Prices for lengths 1 to 8
        int n = 8; // Length of the rod

        System.out.println("Maximum profit: " + cutRod(prices, n));
    }
}


/*
 * 
 * 
Rod Cutting Problem:
The Rod Cutting Problem is a classic problem in computer science and dynamic programming. 
It involves a rod of a given length and a set of prices for different lengths of pieces that can be cut from the rod. 
The objective is to find the maximum profit that can be obtained by cutting the rod into smaller lengths and selling the pieces, 
given the price of each piece of a certain length.

Problem Statement:
You are given:

A rod of length n.
A set of prices P[i] where i represents the length of the rod (1 ≤ i ≤ n) and P[i] is the price of a rod of length i.
The goal is to determine the maximum profit you can obtain by cutting the rod into smaller pieces and selling them. You are allowed to make any number of cuts, and each piece sold must match one of the lengths in the price list.

Input:
n - Length of the rod.
P[] - Array of prices where P[i] represents the price for a rod of length i+1.
Output:
The maximum profit that can be obtained.
 
 ====================================================================================
 Approach:
The Rod Cutting Problem can be solved using Dynamic Programming.

Naive Approach (Brute Force):
You can try all possible ways to cut the rod into smaller pieces and compute the profit for each combination.
This approach is exponential in time complexity and inefficient.
Dynamic Programming Approach:
We can solve this problem efficiently using dynamic programming by solving the sub-problems for smaller rod lengths and combining their results to solve the larger problem.
We use a DP array dp[] where dp[i] represents the maximum profit that can be obtained by cutting a rod of length i.
Dynamic Programming Solution:
Initialize a dp array of size n+1 to store the maximum profit for each rod length.
For each length i (1 to n), find the maximum profit by trying to cut the rod into two parts. One part of length j and the other part of length i-j (where j ranges from 1 to i), and compute the profit.

====================================================================================

Explanation of Code:
prices[]: An array representing the prices for different lengths of the rod.
dp[]: An array where dp[i] stores the maximum profit for a rod of length i.

The outer loop iterates over each rod length from 1 to n. For each rod length, we try cutting it into two smaller pieces, 
calculating the maximum profit for each cut, and update dp[i] with the highest profit.

The inner loop checks all possible cuts by breaking the rod into two parts of length j and i-j and calculating the profit.

The value of dp[n] will give the maximum profit for a rod of length n.

Time Complexity:
The time complexity of this dynamic programming solution is O(n²) because for each rod length i, we are iterating through all possible cuts j from 1 to i.
Space Complexity:
The space complexity is O(n) due to the dp[] array used to store the maximum profits for each rod length.
 * 
 */