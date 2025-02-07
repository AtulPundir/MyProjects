package com.ap.pre.walmart;

import java.util.*;

public class OrderedSetHashMap {

    public static void main(String[] args) {
        // Create a HashMap with LinkedHashSet as values
        Map<String, Set<Integer>> map = new HashMap<>();

        // Add elements to the map
        addToMap(map, "A", 1);
        addToMap(map, "A", 2);
        addToMap(map, "A", 3);
        addToMap(map, "B", 4);
        addToMap(map, "B", 2); // Duplicate value for key "B"
        addToMap(map, "C", 5);

        // Print the map
        printMap(map);
    }

    // Method to add values to the map
    private static void addToMap(Map<String, Set<Integer>> map, String key, int value) {
        // Get the set for the key, or create a new one if it doesn't exist
        map.computeIfAbsent(key, k -> new LinkedHashSet<>());

        // Add the value to the set
        map.get(key).add(value);
    }

    // Method to print the map
    private static void printMap(Map<String, Set<Integer>> map) {
        for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
