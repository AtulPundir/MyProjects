package com.ap.pre.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//https://medium.com/@mehar.chand.cloud/java-stream-hard-interview-questions-54ea0de40acc
public class JavaStreams2 {
    public static void main(String[] args) {
        
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(nums).forEach(System.out::println);


        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        list.forEach(System.out::println);

        List<String> list1 = Arrays.asList("apple", "banana", "orange");

        List<String> list2 = Arrays.asList("grape", "melon", "pineapple");

        Stream<String> stream1 = list1.stream();
        Stream<String> stream2 = list2.stream();

        //Concat
        Stream<String> concatenatedStream = Stream.concat(stream1, stream2);
        concatenatedStream.forEach(System.out::println);

        //GENERATE RANDOM NUMBER
        Random random = new Random();
        Stream<Integer> randomNumbers = Stream.generate(random::nextInt).limit(5);
        randomNumbers.forEach(System.out::println);

        System.out.println(Stream.generate(random::nextInt).findAny());
        System.out.println(Stream.generate(random::nextInt).findFirst());


        //MULTIPLE STREAM TRANSFORMATION
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                                .filter(n -> n % 2 == 0)    // Filter even numbers
                                .mapToDouble(n -> n * 2.0)  // Map to doubles and multiply by 2
                                .average()                  // Calculate the average
                                .orElse(0);
        System.out.println("AVG " + average);




        //STREAM BUILDER
        //Stream.Builder is a helper interface in Java used to build streams. 
        //It allows you to manually add elements to a stream one-by-one and then build the final stream. 
        //This is useful when you need to construct a stream dynamically
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        //Stream<Integer> stream = builder.build();

        //Handling Null
        List<String> listWithNull = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> filteredList = listWithNull.stream()
                                        .map(s -> {
                                            if (s == null) {
                                                return "N/A";
                                            }
                                            // Perform other operations
                                            return s.toUpperCase();
                                        })
                                        .collect(Collectors.toList());

        listWithNull.forEach(System.out::println);
        filteredList.forEach(System.out::println);

        
    }

}
