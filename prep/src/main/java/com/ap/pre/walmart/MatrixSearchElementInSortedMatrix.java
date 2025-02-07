package com.ap.pre.walmart;

public class MatrixSearchElementInSortedMatrix {

    // Function to find a number in a row and column-wise sorted 2D matrix
    public static boolean findNumberInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner of the matrix
        int i = 0;        // Row pointer (starting from the top)
        int j = cols - 1; // Column pointer (starting from the right)

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println("Found " + target + " at position (" + i + ", " + j + ")");
                return true;
            } else if (matrix[i][j] > target) {
                // Move left if the current number is greater than the target
                j--;
            } else {
                // Move down if the current number is smaller than the target
                i++;
            }
        }

        // If the element is not found
        System.out.println(target + " not found in the matrix.");
        return false;
    }

    public static void main(String[] args) {
        // Sample 2D matrix (row and column-wise sorted)
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };

        // Target element to search for
        int target = 29;

        // Find the target in the matrix
        findNumberInMatrix(matrix, target);
    }
}
    
