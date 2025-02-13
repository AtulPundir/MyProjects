package com.ap.pre.datastructures.walmart;

public class CoinFlip {

    public static int minFlips(char[] coins) {
        int flips = 0;
        boolean flipped = false; // Tracks whether we are in a flipped state

        for (char coin : coins) {
            // If the coin is not in the desired state, flip
            if ((coin == 'H' && !flipped) || (coin == 'T' && flipped)) {
                flips++;
                flipped = !flipped; // Toggle the flipped state
            }
        }

        return flips;
    }

    public static int minFlips2(char[] coins) {
        int flips = 0;

        for (int j = 0; j < coins.length ; j++){
            if (coins[j] == 'H'){
            flips++;

            for (int i =j; i < coins.length; i++){
                
                if (coins[i] == 'H'){
                    coins[i] = 'T';
                } else if (coins[i] == 'T'){
                    coins[i] = 'H';
                    
                }
            } 
        }
        }
        return flips;
    }

    public static void main(String[] args) {
        // Example: All coins are initially heads
        char[] coins = {'H', 'H', 'H', 'H', 'T', 'H'};// Output: 3

        int result = minFlips(coins);
        System.out.println("Minimum flips needed: " + result); 
    }
}
    


/*
 * 
 * Problem Statement
You are given N coins placed in a row, all initially showing heads (H). A coin can either be heads (H) or tails (T). You are asked to perform the following operation:

Flip Operation: Choose any coin, flip it (change H to T or T to H), and simultaneously flip all coins to its right.
The task is to determine the minimum number of flip operations required to make all coins show tails (T).

Example
Input:

H H H

Output:

2

Explanation:

Flip the 1st coin:
State: T T T
Now, all coins show T, so the operation stops.


Steps to Solve
1. Traverse the coins from left to right.
2. Track the "current state" (whether you are flipping coins or not).
3. Every time you encounter a coin that doesn't match the desired state (T), flip it and update the "current state."

Explanation of the Code:
1. flippedState:
Tracks whether the coins are currently flipped (i.e., whether H is actually T and vice versa).

2. When to Flip:
Flip if the current coin does not match the desired state (T).

3. Flip Count:
Each flip operation is counted, and the state is toggled.



Variations
1. Grid Version:
Coins are placed in a 2D grid. Flipping a coin also flips all coins in the same row and column.
This problem is often reduced to matrix manipulation or bitwise operations.

2. Generalized State:
Instead of all coins initially being H, they may be randomly distributed as H or T. The solution needs to account for this initial configuration.

3. Dynamic Programming:
If additional constraints (e.g., cost of flipping) are introduced, dynamic programming can be used to find the optimal solution.

 */