package com.ap.pre.walmart.imp;

public class SolutionWRRX {
    public static int minReplacementsToBalance(String[] board) {
        int m = board.length;
        int n = board[0].length();
    
        // Count occurrences of 'R', 'W', and '?' for each row
        int[] rowR = new int[m], rowW = new int[m], rowQ = new int[m];
        int[] colR = new int[n], colW = new int[n], colQ = new int[n];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    rowR[i]++;
                    colR[j]++;
                } else if (c == 'W') {
                    rowW[i]++;
                    colW[j]++;
                } else {
                    rowQ[i]++;
                    colQ[j]++;
                }
            }
        }
    
        // Check if balancing is possible
        for (int i = 0; i < m; i++) {
            if ((rowR[i] + rowW[i] + rowQ[i]) % 2 != 0) return -1;
        }
        for (int j = 0; j < n; j++) {
            if ((colR[j] + colW[j] + colQ[j]) % 2 != 0) return -1;
        }
    
        int replacements = 0;
    
        // Fix rows
        for (int i = 0; i < m; i++) {
            int target = n / 2;
            int neededR = target - rowR[i];
            int neededW = target - rowW[i];
    
            if (neededR > 0) {
                replacements += neededR;
                rowQ[i] -= neededR;
            }
            if (neededW > 0) {
                replacements += neededW;
                rowQ[i] -= neededW;
            }
        }
    
        // Fix columns
        for (int j = 0; j < n; j++) {
            int target = m / 2;
            int neededR = target - colR[j];
            int neededW = target - colW[j];
    
            if (neededR > 0) {
                replacements += neededR;
                colQ[j] -= neededR;
            }
            if (neededW > 0) {
                replacements += neededW;
                colQ[j] -= neededW;
            }
        }
    
        return replacements;
    }

    public static void main(String[] args) {
        String[] rows = {
            "W?WR?", 
            "??W??",
            "W??RW",
            "?RWR?"
        };
        System.out.println("\nFinal Output: " + minReplacementsToBalance(rows));
    }

}




/*
There Is a board to be made with 2 rows and n columns.The Board is represented by 2 Strings 
row1 and row2 made up of characters R, W  &/OR ‘?’.A Board is balanced if, in each row& in each column,  
the number of Characters R is equals  to number of characters W.‘?’ can be replace with R or W to make the balance.
Return Minimum number of replacements to make the board balanced. 
If not possible then return -1;row1 = “W?WR?”, row2 = “??W??”


 * 
 * 
 */
