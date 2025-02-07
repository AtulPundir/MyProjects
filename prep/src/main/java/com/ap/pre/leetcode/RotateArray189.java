package com.ap.pre.leetcode;

//MEDIUM
public class RotateArray189 {

    public  static void rotate(int[] nums, int k) {
        int next = nums[0];
        int len = nums.length;
        k = k % len;
        if (k == 0) return;

        for (int j = 0; j < k; j++){


        for (int i =0; i<len-1; i++){
            int temp = nums[i+1];
            nums[i+1] = next;
            next = temp;
        }
        nums[0] = next;
        print(nums);
    }
      //nums[0] = next;

    }

    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Handle cases where k > n
        if (k == 0) return; // No rotation needed if k is 0 or a multiple of n
        print(nums);
        // Step 1: Reverse the entire array
        reverse(nums, 0, len - 1);
        print(nums);
    
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        print(nums);
        
    
        // Step 3: Reverse the remaining elements
        reverse(nums, k, len - 1);
        print(nums);
    }
    
    // Helper method to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Handle cases where k > n
        if (k == 0) return;
    
        int count = 0; // Tracks how many elements have been moved
        int start = 0; // Start index of the current cycle
    
        while (count < len) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % len; // Calculate the new index
                int temp = nums[next]; // Store the value at the new index
                nums[next] = prev; // Move the current value to the new index
                prev = temp; // Update the value to be moved next
                current = next; // Move to the next index in the cycle
                count++; // Increment the number of elements processed
            } while (current != start); // End the cycle when back at the start
            start++; // Start a new cycle
        }
    }

    

    static void print(int[] nums){
        System.out.println("ITERATION j = ");
        for (int a : nums){
            System.out.print(" " +a);
            }
        System.out.println();
        System.out.println();
    }
 
    
    public static void main(String[] args) {
        //int[] nums = {1,2,3,4,5,6,7};
        int[] nums ={-1,-100,3,99};

        int k=2;

        rotate2(nums, k);
        
    }

}




/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100] */