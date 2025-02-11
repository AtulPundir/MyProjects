package com.ap.pre.leetcode;

import java.util.Map;
import java.util.HashMap;

public class MyCargoGate {

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,4,8,16,32,64,128,256,512};


        int target = 1024;

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i = nums.length-1; i >=0; i--){

            while (nums[i] <= target){
                sum = sum + nums[i];
                target = target - nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            }
  
        } 
        for (int x : map.keySet()){
            System.out.println(x +" "+ map.get(x));

        }


    }

}
