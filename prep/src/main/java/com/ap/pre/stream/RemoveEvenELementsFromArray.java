package com.ap.pre.stream;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveEvenELementsFromArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        List<Integer> result = list.stream().filter(x -> x%2!=0)
                                            .collect(Collectors.toList());

        System.out.println(result);

        list.removeIf(n -> n % 2 == 0);
        
        System.out.println();
        System.out.println(list);
    }
    
}
