package com.ap.pre.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class A767ReorganizeString {

    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max Heap based on character frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        // Step 3: Build the rearranged string
        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            result.append(curr.getKey());

            // Reduce frequency and store the previous character
            if (prev != null && prev.getValue() > 0) {
                maxHeap.offer(prev);
            }

            curr.setValue(curr.getValue() - 1);
            prev = curr;
        }

        // Step 4: Check if we formed a valid string
        return result.length() == s.length() ? result.toString() : "";
    }

    public static String reorganizeString2(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Find the most frequent character
        int maxFreq = 0, maxCharIndex = 0, n = s.length();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxCharIndex = i;
            }
        }

        // Step 3: Check if rearrangement is possible
        if (maxFreq > (n + 1) / 2) {
            return ""; // Not possible to rearrange
        }

        // Step 4: Fill the array, placing the most frequent character first
        char[] result = new char[n];
        int index = 0;

        // Fill the most frequent character first at even indices
        while (freq[maxCharIndex] > 0) {
            result[index] = (char) ('a' + maxCharIndex);
            freq[maxCharIndex]--;
            index += 2;
        }

        // Step 5: Fill remaining characters in the result array
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= n) index = 1; // Start filling odd indices
                result[index] = (char) ('a' + i);
                freq[i]--;
                index += 2;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("baaba"));
    }

}


/*
 * 
 * 
 Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""

 * 
 */