package com.ap.pre.leetcode.epam;

import java.util.HashMap;
import java.util.Map;

//EASY
public class A1TwoSum {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};

        var res = twoSum(nums, 18);
        System.out.println(res.toString());
        for (int x : res ){
            System.out.println(x);
        }
        
        
    }

    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 1) return null;
        int[] res = new int[2];
        for (int i =0; i < nums.length; i ++){
            for(int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return res;
    }

     public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}


/*
 * 
 1. Two Sum
EASY
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


 */