package com.ap.pre.leetcode;

public class RemoveElement28 {

        public static int[] removeElement(int[] nums, int val) {
            //int res = 0;
            int len = nums.length;
            int[] arr = new int[len];
            int count = 0; 
            //int countVal = 0; 
            
            for (int i =0; i < len; i++){
                if (nums[i] != val){
                    arr[count] = nums[i];
                    count++;
                }   else {
                   // countVal++;
                }
            }
            nums = arr;
            //res = len - countVal;
            //return res;
            return nums;
        }



    public static void printArray(int[] arr) {
        System.out.print("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
         int val = 3;
         printArray(removeElement(nums, val));
      System.out.println( removeElement(nums, val));
    }
}
