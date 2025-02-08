package com.ap.pre.datastructures.walmart.imp;

import java.util.Stack;

public class SmallestGreaterThanInput {

    public static int nextGreaterElement(int n) {
        //int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();

        //START  //// use this from start to end If we want to replace the above line 
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
         stack.push(n % 10);
            n /= 10;
        }
        int[] digits = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            digits[index] = stack.pop();
            index++;
        }
        //END
        
        //int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();
        int length = digits.length;
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {  //comparing secondlast with last
            i--;
        }

        if (i == -1) {         // If no such pivot exists, return -1 (no larger permutation possible)
            return -1;
        }
    
        int j = length - 1;            // If no such pivot exists, return -1 (no larger permutation possible)
        while (digits[j] <= digits[i]) {
            j--;
        }
    
        int temp = digits[i];    // Step 3: Swap the pivot and the element just larger than it
        digits[i] = digits[j];
        digits[j] = temp;
        
        int start = i + 1;      // Step 4: Reverse the part after the pivot to get the smallest number
        int end = length - 1;   
        while (start < end) {
            temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }
    
        long result = 0;                // Convert the integer array back to a number
        for (int digit : digits) {
            result = result * 10 + digit;
        }
    
        // Handle overflow
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }



    public static void main(String[] args) {
        int n = 1243;
        int result = nextGreaterElement(n);
        System.out.println("Next greater element: " + result);  // Output: 132
    }

    //USE OF INT AND COMMENTS PURPOSE
    public static int nextGreaterElement3(int n) {
        // Convert the number to an integer array (digits of the number)
        int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();
        int length = digits.length;
    
        // Step 1: Find the pivot - first decreasing element from right
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
    
        // If no such pivot exists, return -1 (no larger permutation possible)
        if (i == -1) {
            return -1;
        }
    
        // Step 2: Find the element just larger than the pivot
        int j = length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
    
        // Step 3: Swap the pivot and the element just larger than it
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    
        // Step 4: Reverse the part after the pivot to get the smallest number
        int start = i + 1;
        int end = length - 1;
        while (start < end) {
            temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }
    
        // Convert the integer array back to a number
        long result = 0;
        for (int digit : digits) {
            result = result * 10 + digit;
        }
    
        // Handle overflow
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    // USE OF CHAR 
     // Function to find the next lexicographical permutation
     public static int nextGreaterElement2(int n) {
        // Convert the number to a character array to work with digits
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;

        // Step 1: Find the pivot - first decreasing element from right
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such pivot exists, return -1 (no larger permutation possible)
        if (i == -1) {
            return -1;
        }

        // Step 2: Find the element just larger than the pivot
        int j = length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the pivot and the element just larger than it
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse the part after the pivot to get the smallest number
        int start = i + 1;
        int end = length - 1;
        while (start < end) {
            temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }
        // Convert the character array back to an integer and return it
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;  // Handle overflow
    }
}



/*
 * 
 * 
Given the positive integer n , find the smallest integer which has exactly the same digits existing in the integer n and is greater than n.
If no such positive integer exists, then return 1. I/O => 123 | OP => 132

 * 
 */