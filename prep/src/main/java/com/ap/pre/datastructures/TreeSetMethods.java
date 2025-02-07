package com.ap.pre.datastructures;

import java.util.TreeSet;

public class TreeSetMethods {
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);
        
        System.out.println(set); // Output: [5, 10, 15, 20]
        
        // Get first and last element
        System.out.println(set.first());  // Output: 5
        System.out.println(set.last());   // Output: 20

        // Get elements just smaller or greater than a given value
        System.out.println("Lower " + set.lower(15));   // Output: 10 (Element just smaller than 15)
        System.out.println("Higher" + set.higher(15));  // Output: 20 (Element just greater than 15)

        // Get floor and ceiling values
        System.out.println(set.floor(14));  // Output: 10 (Largest ≤ 14)
        System.out.println(set.ceiling(14)); // Output: 15 (Smallest ≥ 14)

        TreeSet<String> set2 = new TreeSet<>();
        set2.add("Atul");
        set2.add("Abhishek");
        set2.add("Surya");
        set2.add("Nabhdeep");

        System.out.println(set2.first());  
        System.out.println(set2.last());

        System.out.println("Lower " + set2.lower("Atul"));   // Output: 10 (Element just smaller than 15)
        System.out.println("Higher" + set2.higher("Atul"));
    }
}