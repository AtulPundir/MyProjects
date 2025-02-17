package com.ap.pre.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A56MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();

        // Step 2: Merge intervals
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) { // Overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Non-overlapping interval, add to the list
                currentInterval = interval;
                mergedList.add(currentInterval);
            }
        }

        // Convert List to 2D Array
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals1))); // Output: [[1,6],[8,10],[15,18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge(intervals2))); // Output: [[1,5]]

        int[][] intervals3 = {{1,4},{0,4}};
        System.out.println(Arrays.deepToString(merge(intervals3))); // Output: [[0,4]]
    }

}



/*
 * 
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
  
 * 
 */
