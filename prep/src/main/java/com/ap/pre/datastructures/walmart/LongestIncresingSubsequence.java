package com.ap.pre.walmart;

public class LongestIncresingSubsequence {

    // Function to find the length of the Longest Increasing Subsequence
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        // dp[i] will store the length of the LIS ending at index i
        int[] dp = new int[nums.length];
        dp[0] = 1; // The first element always has an LIS of 1

        // Build the dp array
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // Initialize to 1 (itself as a subsequence)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // If nums[i] can extend the subsequence ending at nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The answer will be the maximum value in dp[]
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums));
    }
}

