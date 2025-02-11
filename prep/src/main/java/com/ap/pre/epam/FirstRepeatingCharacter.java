package com.ap.pre.epam;

import java.util.HashSet;
import java.util.Optional;

public class FirstRepeatingCharacter {
    public static void main(String[] args) {
        String str = "asdfaghjklkjhgfdsa";
        HashSet<Character> seen = new HashSet<>();

        Optional<Character> firstRepeating = str.chars()
                .mapToObj(c -> (char) c) // Convert int to Character
                .filter(c -> !seen.add(c)) // HashSet#add returns false if duplicate
                .findFirst();

        System.out.println("First Repeating Character: " + firstRepeating.orElse(null));
    }
}