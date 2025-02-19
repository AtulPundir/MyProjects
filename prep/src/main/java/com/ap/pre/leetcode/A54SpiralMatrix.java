package com.ap.pre.leetcode;

import java.util.List;
import java.util.ArrayList;

//MEDIUM
public class A54SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0, left = 0;
        int rows = matrix.length - 1, columns = matrix[0].length - 1;

        while (top <= rows && left <= columns) {
            // Traverse from left to right
            for (int i = left; i <= columns; i++) {
                result.add(matrix[top][i]);
            }
            top++;  // Move down the top boundary

            // Traverse from top to bottom
            for (int i = top; i <= rows; i++){
                result.add(matrix[i][columns]);
            }
            columns--;  // Move left the right boundary

            // Check if we still have rows remaining
            if (top <= rows) {
                // Traverse from right to left
                for (int i = columns; i >= left; i--) {
                    result.add(matrix[rows][i]);
                }
                rows--;  // Move up the bottom boundary
            }

            // Check if we still have columns remaining
            if (left <= columns) {
                // Traverse from bottom to top
                for (int i = rows; i >= top; i--) result.add(matrix[i][left]);
                left++;  // Move right the left boundary
            }
        }

        return result;
    }


    public static List<Integer> spiralOrder2(int[][] grid) {
        List<Integer> result = new ArrayList<>();

        if (grid == null || grid.length == 0) return result;

        int topRow= 0, leftColumn  = 0;
        int bottomRow = grid.length -1 , rightColumn = grid[0].length -1 ;

       while (topRow <= bottomRow && leftColumn <=rightColumn){

            for (int i = leftColumn; i <= rightColumn; i ++){
                result.add(grid[topRow][i]);
            }
            topRow++;

            for (int i = topRow ; i <= bottomRow; i++){
                result.add(grid[i][rightColumn]);
            }
            rightColumn--;

            if (topRow <= bottomRow) {
                for (int i =rightColumn; i >= leftColumn; i--){
                    result.add(grid[bottomRow][i]);
                }
                bottomRow--;
            }   
            if (leftColumn <= rightColumn) {
                for (int i = bottomRow; i >= topRow; i--) {
                    result.add(grid[i][leftColumn]);
                }
                leftColumn++;
            }

        }
    
        return result;
    }

    public static void main(String[] args) {

        int[][] matrix0 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] matrix01 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        int[][] matrix02 = {{1, 2, 3, 13}, {4, 5, 6, 14}, {7, 8, 9, 15}, {10, 11, 12, 16}};
        int[][] matrix03 = {{1, 2, 3, 13}, {4, 5, 6, 14}, {7, 8, 9, 15}};

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        //System.out.println(spiralOrder2(matrix0)); // Output: [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]

        //System.out.println(spiralOrder2(matrix01));
        //System.out.println(spiralOrder2(matrix02));
        System.out.println(spiralOrder2(matrix03));

        //System.out.println(spiralOrder(matrix0)); // Output: [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]
        //System.out.println(spiralOrder(matrix1)); // Output: [1,2,3,6,9,8,7,4,5]
        //System.out.println(spiralOrder(matrix2)); // Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}