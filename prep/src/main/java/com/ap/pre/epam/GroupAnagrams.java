package com.ap.pre.epam;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
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

class Resource implements AutoCloseable {
    public void use() { System.out.println("Using resource..."); }
    
    @Override
    public void close() {
        System.out.println("Resource closed!");
    }

}