package com.ap.pre.datastructures.walmart.knapsack;

//USING class. provides encapsulation
public class Knapsack2 {
    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int knapsack(Item[] items, int W) {
        int n = items.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (items[i - 1].weight <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w], 
                        dp[i - 1][w - items[i - 1].weight] + items[i - 1].value
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(2, 3),
            new Item(3, 4),
            new Item(4, 5),
            new Item(5, 6)
        };
        int W = 5;

        System.out.println("Maximum value: " + knapsack(items, W));
    }
}
