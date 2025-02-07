package com.ap.pre.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class FindDuplicateInArray {

    private static List<Integer> findDuplicate(int[] arr) {
        List<Integer> result  = new ArrayList<Integer>();;
        HashSet<Integer> set  = new HashSet<>(); 
        for (int x : arr) {
           if ( !set.add(x)){
            result.add(x);
           } 

        }

        return result; 
        
    }


    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1,2};

        List<Integer> result = findDuplicate(arr);

        for (int x : result){
            System.out.println(x);
        }
    }
}
