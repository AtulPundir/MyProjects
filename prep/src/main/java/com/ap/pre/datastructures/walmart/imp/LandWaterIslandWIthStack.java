package com.ap.pre.walmart.imp;

import java.util.Stack;

public class LandWaterIslandWIthStack {
    // Function to perform DFS using an explicit stack
    private static void dfsIterative(char[][] grid, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}  // Up, Down, Left, Right
        };

        // Directions array for all 8 possible movements
        int[][] directions1 = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},  // Up, Down, Left, Right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonals
        };

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0];
            int y = cell[1];

            // If out of bounds or already visited, skip
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                continue;
            }

            grid[x][y] = '0';       //Makring Visited

            // Push all possible directions to the stack
            for (int[] dir : directions) {
                stack.push(new int[]{x + dir[0], y + dir[1]});
            }
        }
    }


    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++; 
                    dfsIterative(grid, i, j); //DFS with stack
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        int result = numIslands(grid);
        System.out.println("Number of Islands: " + result); // Expected output: 3
    }
}

