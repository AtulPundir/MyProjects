package com.ap.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blooming {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,2,3,3);  // {1,4}, {2,3}, {2,3}, {2,3}, {3,2}, {2,3} {2,3}
        int target = 5;

       List<int []> result = getList(nums, target);

        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }

        
    }

    public static List<int []> getList(List<Integer> nums, int target){
        List<int[]> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        //As you gave an hint to use locations, so I am storing in map based on locations.
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int complement = target - num;
            if (map.containsKey(complement)) {
                for (int index : map.get(complement)) {     //Wanted to iterate here so I used List<Integer> as value
                    if (index < i) {
                        result.add(new int[]{nums.get(index), nums.get(i)}); 
                        //result.add(new int[]{index, i});      //stroring  index incase to verify the locations
                    }
                }
            }
            map.putIfAbsent(num, new ArrayList<>());

            map.get(num).add(i);
        }

         return result;


    }

}


