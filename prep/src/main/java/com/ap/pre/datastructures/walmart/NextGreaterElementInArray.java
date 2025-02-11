package com.ap.pre.datastructures.walmart;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInArray {

    public static int[] findNextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default value if no greater element is found
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break; // Stop searching once the next greater element is found
                }
            }
        }

        return result;
    }

    //OPtimal
    public static int[] findNextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove all elements smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If the stack is not empty, the top element is the next greater
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static int findNextGreaterElements2(int[] nums) {
        int len = nums.length;
        int greater = -1, ng = -1;
        for(int i =0; i < len; i++){
            if(nums[i] > ng){
                if (nums[i] > greater) {
                    ng = greater;
                    greater = nums[i];
                } else {
                    ng = nums[i];
                }
            }
        }
        return ng;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = findNextGreaterElements(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + Arrays.toString(result));

        System.out.println(findNextGreaterElements2(nums));
    }
}
