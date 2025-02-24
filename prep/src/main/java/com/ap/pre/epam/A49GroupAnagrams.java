package com.ap.pre.epam;

import java.util.*;
import java.util.stream.Collectors;

//MEDIUM
public class A49GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        word -> {
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars); // Sort the characters
                            return new String(chars); // Use sorted string as key
                        }
                )).values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // If key doesn't exist, create a new list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values()); // Convert Map values to List<List<String>>
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams2(strs));
    }

    
}


/*
Given an array of strings strs, group the 
anagrams
 together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]] */
