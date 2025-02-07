package com.ap.pre.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class A380InsertDeleteGetRandomAtOnComplexityOptimized {

    private final Map<Integer, Integer> valueIndexMap; // Maps value to its index in the list
    private final List<Integer> values;              // List to store values for random access
    private final Random random;                     // Random instance for getRandom

    public A380InsertDeleteGetRandomAtOnComplexityOptimized() {
        valueIndexMap = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    // Inserts a value into the data structure. Returns true if the value was not already present.
    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) {
            return false; // Value already exists
        }
        values.add(val);
        valueIndexMap.put(val, values.size() - 1); // Map value to its index in the list
        return true;
    }

    // Removes a value from the data structure. Returns true if the value was present.
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)) {
            return false; // Value does not exist
        }
        int index = valueIndexMap.get(val); // Get the index of the value to remove
        int lastValue = values.get(values.size() - 1); // Get the last value in the list

        // Swap the value to remove with the last value
        values.set(index, lastValue);
        valueIndexMap.put(lastValue, index);

        // Remove the last value from the list and the map
        values.remove(values.size() - 1);
        valueIndexMap.remove(val);
        return true;
    }

    // Returns a random value from the data structure.
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {
        A380InsertDeleteGetRandomAtOnComplexityOptimized obj = new A380InsertDeleteGetRandomAtOnComplexityOptimized();
        boolean param_1 = obj.insert(1);
        System.out.println(param_1);
        
        boolean param_2 = obj.remove(2);
        System.out.println(param_2);
        
        boolean param_11 = obj.insert(2);
        System.out.println(param_11);
        
        int param_3 = obj.getRandom();
        System.out.println(param_3);

        boolean param_21 = obj.remove(1);
        System.out.println(param_21);
        
        boolean param_12 = obj.insert(2);
        System.out.println(param_12);
        
        int param_31 = obj.getRandom();
        System.out.println(param_31);
        
    }

}
