package com.ap.pre.datastructures.walmart.imp;

import java.util.LinkedList;
import java.util.Queue;

public class LandWaterIslandBFS {

    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0'; //markingn it as visited

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            // Check all 4 possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Ensure the new cell is within bounds and is land ('1')
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1') {
                    queue.add(new int[]{newX, newY}); // Enqueue new land cell
                    grid[newX][newY] = '0'; // Mark it as visited
                }
            }
        }
    }

    // Function to count the number of islands using BFS
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    bfs(grid, i, j);
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

