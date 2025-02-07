package com.ap.pre.stream;

import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams implements Cloneable{

    public static void main(String[] args) {

        List <Integer> testList = Arrays.asList(1,2,3,4,5,6,1, 8, 7, 9, 2, 7,9);
        Set<Integer> set = testList.stream().collect(Collectors.toSet());
        System.out.println(set);
        Set<Integer> set2 = set.stream().filter(n -> n%2 !=0).collect(Collectors.toSet());
        System.out.println(set2);
        
        //Filter (Keep only specific elements)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList()); // [2,4,6]
            
        //Map (Transform elements)
        List<String> names = List.of("alice", "bob", "charlie");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList()); // ["ALICE", "BOB", "CHARLIE"]
            
        //FlatMap (Flatten nested structures)
        List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()); // [1, 2, 3, 4]
            
        //Distinct (Remove duplicates)
        List<Integer> distinctNumbers = List.of(1, 2, 2, 3, 4, 4, 5).stream()
                .distinct()
                .collect(Collectors.toList()); // [1,2,3,4,5]
            
        ////Sorted (Sorting elements)
        List<String> sortedNames = List.of("Charlie", "Alice", "Bob").stream()
                .sorted()
                .collect(Collectors.toList()); // ["Alice", "Bob", "Charlie"]
            
            
        //Peek (Debugging stream elements)
        List<Integer> processed = List.of(1, 2, 3, 4, 5).stream()
                .peek(n -> System.out.println("Processing: " + n))
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

}
