package com.ap.pre.leetcode;

import java.util.Arrays;

//Medium
public class A253MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] allStarts = new int[len];
        int[] allEnds = new int[len];
        for(int i=0; i<intervals.length; i++) {
            allStarts[i] = intervals[i][0];
            allEnds[i] = intervals[i][1];
        }
        Arrays.sort(allStarts);
        Arrays.sort(allEnds);
        int rooms = 0;
        int endLocation = 0;
        for(int i=0; i < allStarts.length; i++) {
            if(allStarts[i] < allEnds[endLocation]){
                rooms++;
            } else{
                endLocation++;
            }    
        }
        return rooms;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,30},{5,10},{15,20}};

        System.out.println(minMeetingRooms(arr));
        
    }

}




/*
 * 
 Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

 * 
 * 
 */
