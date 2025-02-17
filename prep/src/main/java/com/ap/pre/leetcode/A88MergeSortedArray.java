package com.ap.pre.leetcode;

public class A88MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1ValidElementIndex = m - 1;  // Last index of nums1's actual elements
        int nums2LastIndex = n - 1;  // Last index of nums2
        int i = m + n - 1;  // Last index of nums1 (including extra space)

        // Merge from the back to avoid shifting elements
        while (nums1ValidElementIndex >= 0 && nums2LastIndex >= 0) {
            if (nums1[nums1ValidElementIndex] > nums2[nums2LastIndex]) {
                nums1[i] = nums1[nums1ValidElementIndex];  // Place the larger value at the end
                i--;
                nums1ValidElementIndex--;

                //nums1[i--] = nums1[nums1ValidElementIndex--];
            } else {
                nums1[i] = nums2[nums2LastIndex];
                i--;
                nums2LastIndex--;

                //nums1[i--] = nums2[nums2LastIndex--];    
           }
        }
        while (nums2LastIndex >= 0) {
            nums1[i] = nums2[nums2LastIndex];
            i--;
            nums2LastIndex--;
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int nums1ValidElement = m - 1;
        int nums2LastIndex = n - 1;
        int lastIndex = m + n - 1;

        while (nums1ValidElement >= 0 && nums2LastIndex >= 0) {
            if (nums1[nums1ValidElement] > nums2[nums2LastIndex]) {
                nums1[lastIndex] = nums1[nums1ValidElement];
                lastIndex--;
                nums1ValidElement--;
            } else {
                nums1[lastIndex] = nums2[nums2LastIndex];
                lastIndex--;
                nums2LastIndex--;
            }
        }

        while (nums2LastIndex >= 0) {
            nums1[lastIndex] = nums2[nums2LastIndex];
            lastIndex--; 
            nums2LastIndex--;
            
        }
    }
    

    public static void main(String[] args) {

       int [] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
       int m = 3,  n = 3;

       System.out.println(nums1.length);

       merge(nums1, m, nums2, n);

       for (int x : nums1 ){
        System.out.print(x +" ");
       }
      
        
    }

}


/*
 * 
 
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


 * 
 */