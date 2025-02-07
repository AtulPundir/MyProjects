package com.ap.pre.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class H_Index274 {

    public static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
        
    }

    //More time and space efficient as it not using the Arrays.sort
    public static int hIndex2(int[] citations) {
        int len = citations.length;
        int[] countArr = new int[len + 1];
 
        for (int c : citations) {
            if (c >= len) {
                countArr[len]++;
            } else {
                countArr[c]++;
            }
        }
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += countArr[i];
            if (sum >= i) {
                return i;
            }
        }
    
        return 0;
    }


     //More time and space efficient as it not using the Arrays.sort
     public static int hIndex3(int[] citations) {
        int len = citations.length;
        Map<Integer, Integer> citationCount = new HashMap<>();

        for (int c : citations) {
            if (c >= len) {
                citationCount.put(len, citationCount.getOrDefault(len, 0) + 1);
            } else {
                citationCount.put(c, citationCount.getOrDefault(c, 0) + 1);
            }
        }

        int cumulativePapers = 0;
        for (int i = len; i >= 0; i--) {
            cumulativePapers += citationCount.getOrDefault(i, 0);
            if (cumulativePapers >= i) {
                return i;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int [] citations = {3,0,6,1,5};

        System.out.println(hIndex2(citations));
    }

}



/*
 * 
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, 
return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher 
has published at least h papers that have each been cited at least h times.

 

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1

 */