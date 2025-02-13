package com.ap.pre.epam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        String [] strs = {"abc", "xyshf", "axd", "jadfjbk", "testing", "axd", "ac"};


        List<String> list = Arrays.asList(strs).stream()
                                                .filter(s -> s.length()<=3)
                                                .distinct()
                                                .map(String::toUpperCase)
                                                .collect(Collectors.toList());

        System.out.println(list);

        int [] nums = {1,2,3,4,5,6,7};
        int [] nums1 = {5,5,5,1};
        System.out.println(getSecondLargest(nums));
        System.out.println(getSecondLargest(nums1));
    }

    static int getSecondLargest(int [] nums){
        if (nums == null || nums.length < 2) return 0;
        int largest = Integer.MIN_VALUE;
        int secondL= Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++){
            if (nums[i]> largest){
                secondL = largest;
                largest = nums[i];

            } else if (nums[i]> secondL && nums[i] != largest) {
                secondL = nums[i];

            }
            if (largest == secondL){
                throw new RuntimeException("Same numbers");
            }

        }
        return secondL;

    }

}
