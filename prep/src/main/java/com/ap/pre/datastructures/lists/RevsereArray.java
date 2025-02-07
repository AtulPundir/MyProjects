package com.ap.pre.datastructures.lists;

public class RevsereArray {


    static void reverse(int [] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--; 
        }
      }

      public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        //int[] nums ={-1,-100,3,99};

        reverse(nums,0, nums.length-1);
        
    }



}
