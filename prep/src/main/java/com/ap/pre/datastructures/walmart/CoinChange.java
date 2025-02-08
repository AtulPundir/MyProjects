package com.ap.pre.datastructures.walmart;

import java.util.Arrays;

//LEET CODE 322   
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Create a DP array and initialize it to a large value
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1); // Use amount + 1 as a placeholder for "infinity"
        arr[0] = 0; // Base case: 0 coins to make amount 0

        // Fill the DP table
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    //arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                    if (arr[i - coin] + 1 < arr[i]) {
                        arr[i] = arr[i - coin] + 1;
                    }
                }
            }
        }

        // Return the result
        return arr[amount] > amount ? -1 : arr[amount];
    }

    public static int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
    
        for (int coin : coins) {
            if (amount >= coin) {
                int res = coinChangeRecursive(coins, amount - coin);
                if (res != -1) {
                    if (res + 1 < minCoins) { // Manually updating minCoins
                        minCoins = res + 1;
                    }
                }
            }
        }
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins1, amount1)); // Output: 3

        // Test case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Minimum coins needed: " + coinChange(coins2, amount2)); // Output: -1

        // Test case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Minimum coins needed: " + coinChange(coins3, amount3)); // Output: 0
    }
}



/*
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

 */