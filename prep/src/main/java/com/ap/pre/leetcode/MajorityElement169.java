package com.ap.pre.leetcode;

import java.util.HashMap;

//EASY
public class MajorityElement169 {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int major = 0;
        int majorCount =0;

        for (int i : map.keySet()){
            if (map.get(i) > majorCount){
                major = i;
                majorCount = map.get(i);
            } 
        }

        System.out.println(map);
        
        return major;
        
    }

    

    public static void main(String[] args) {
        //int [] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2,3,3,3};

        System.out.println(majorityElement(nums));
     
        System.out.println(majorityElement2(nums));

        
        
    }

    public static int majorityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Phase 1: Find the candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify the candidate (optional in this case since problem guarantees majority element exists)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        // This return is not needed because the problem guarantees a majority element.
        return -1;
    }
}




/*
 *
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
  
 * 
 * 
 */