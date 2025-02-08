package com.ap.pre.walmart.imp;

import java.util.*;

public class NQueens {
    
     public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        dfs(n, 0, new ArrayList<>(), solutions);
        return solutions;
    }

    private static void dfs(int n, int row, List<Integer> queenPositions, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(constructBoard(n, queenPositions));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queenPositions, row, col)) {
                queenPositions.add(col);
                dfs(n, row + 1, queenPositions, solutions);
                queenPositions.remove(queenPositions.size() - 1); // Backtrack
            }
        }
    }

    private static boolean isSafe(List<Integer> queenPositions, int row, int col) {
        for (int r = 0; r < row; r++) {
            int c = queenPositions.get(r);
            if (c == col || Math.abs(c - col) == Math.abs(r - row)) {
                return false; // Same column or diagonal conflict
            }
        }
        return true;
    }

    private static List<String> constructBoard(int n, List<Integer> queenPositions) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            char[] rowArr = new char[n];
            Arrays.fill(rowArr, '.');
            rowArr[queenPositions.get(row)] = 'Q';
            board.add(new String(rowArr));
        }
        return board;
    }



    public static void main(String[] args) {
        int n = 4; // Change this value for different board sizes
        List<List<String>> solutions = solveNQueens(n);

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
        
    

}
