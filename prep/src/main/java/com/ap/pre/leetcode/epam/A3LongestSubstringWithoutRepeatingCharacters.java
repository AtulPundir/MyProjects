package com.ap.pre.leetcode.epam;

import java.util.HashSet;
import java.util.Set;

public class A3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        //System.out.println(lengthOfLongestSubstring("abcabcbb"));  //O/P => 3
        //System.out.println(lengthOfLongestSubstring("pwwkew"));  //O/P => 3
        //System.out.println(lengthOfLongestSubstring("aab"));  //O/P => 2
        System.out.println(lengthOfLongestSubstring("atdvsdfegxl")); 
        
    }
    private static int lengthOfLongestSubstring(String s) {
      int finalCount = 0;
      int position = 0;
      Set<Character> set = new HashSet<>();

      for (int i = 0; i < s.length(); i++){
        while (set.contains(s.charAt(i))){
            set.remove(s.charAt(position));
            position++;
        }
        set.add(s.charAt(i));
        finalCount = Math.max(finalCount, i - position +1);
      }
      return finalCount;
    }

}




/*
 Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 */