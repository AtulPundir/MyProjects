package com.ap.pre.leetcode.epam;

import java.util.HashMap;
import java.util.Map;

//EASY
public class A242ValidAnagram {
    public static void main(String[] args) {
        //System.out.println(isAnagram("anagram", "nagaram"));

        //System.out.println(isAnagram("ab", "a"));

        System.out.println('a');

        System.out.println(isAnagram9("car", "rat"));
        
    }

    //14ms
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (Character c : t.toCharArray()){
            if (!map.containsKey(c) || map.get(c) < 1){
                return false;
            } 
            map.put(c, map.get(c) - 1);
        }

        // we are avoiding to add any new as if the key doesnt match we return false, so the below will not be required
       /* for (Character c : map.keySet()){
            if (map.get(c) > 0){
                return false;
            }
        } */


        return true;
    }

    //6ms
    public static boolean isAnagram9(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
       }
       for (int x : arr){
            if(x != 0) return false;
       }
        return true;
    }

    //28ms
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i =0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }
       for (Character c : map.keySet()){
            if (map.get(c) > 0){
                return false;
            }
        }
        return true;
    }

}


/*

 Given two strings s and t, return true if t is an 
anagram
 of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false


 */