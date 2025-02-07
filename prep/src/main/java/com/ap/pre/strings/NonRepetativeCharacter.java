package com.ap.pre.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepetativeCharacter {

    public static void main(String[] args) {

        String str = "aabbcdeff";
        //HashSet<Character> set = new HashSet<>();

        nonRepeatedCharacter(str);
        Character result = findFirstNonRepeatedChar(str);
        System.out.println("First non-repeated character: " + result);
    }

    private static void nonRepeatedCharacter(String str) {
        HashMap<Character, Integer> map = new HashMap<>();  //Does not gurantee the order

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
               // map.getOrDefault(map, null);
            } else {
                map.put(currentChar, 1);
            }

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Key with value 1: " + entry.getKey());
                // break;
            }

        }
    }

    static Character findFirstNonRepeatedChar(String str) {
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            linkedHashMap.put(c, linkedHashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : linkedHashMap.keySet()) {
            System.out.println(c + ":"+ linkedHashMap.get(c));
            if (linkedHashMap.get(c) == 1) {
                return c; // Return the first non-repeated character
            }
        }
        return null; // No non-repeated character found
    }

}
