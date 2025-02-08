package com.ap.pre.walmart;

public class MatrixSearchElementInUnsortedMatrix {

    // Function to find a number in an unsorted 2D matrix
    public static boolean findNumberInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Traverse each element in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("Found " + target + " at position (" + i + ", " + j + ")");
                    return true; // Found the target
                }
            }
        }

        // If the element is not found
        System.out.println(target + " not found in the matrix.");
        return false;
    }

    public static void main(String[] args) {
        // Sample unsorted 2D matrix
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
    
