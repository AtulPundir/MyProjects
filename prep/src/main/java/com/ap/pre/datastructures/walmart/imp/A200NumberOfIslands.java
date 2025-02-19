package com.ap.pre.datastructures.walmart.imp;

public class A200NumberOfIslands {

    // Function to perform DFS and mark all connected lands as visited
    private static void dfs(char[][] grid, int i, int j) {
        // Base case: If the current cell is out of bounds or water (0), return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the current land as visited (change 1 to 0)
        grid[i][j] = '0'; 

        // Explore all four directions (up, down, left, right)
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left

        dfs(grid, i - 1, j - 1); // Top-left diagonal
        dfs(grid, i - 1, j + 1); // Top-right diagonal
        dfs(grid, i + 1, j - 1); // Bottom-left diagonal
        dfs(grid, i + 1, j + 1); // Bottom-right diagonal
    }

    // Function to find the number of islands
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islandCount = 0;

        // Traverse the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we find a land (1), it's a new island
                if (grid[i][j] == '1') {
                    islandCount++; // Increase the island count
                    dfs(grid, i, j); // Perform DFS to mark all connected land
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
       // LandWaterIsland solution = new LandWaterIsland();

        // Example grid (4x5 matrix as per problem description)
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        // Call the numIslands function
        int result = numIslands(grid);
        System.out.println("Number of Islands: " + result); // Output the result
    }

    
}


/*
 * 
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 * 
 */