package com.ap.pre.misc;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSum {

    // Time = O(n2) Space = O(1)
    private static void findTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
       for(int i = 0; i < arr.length -2 ; i++){

        int left = i+1;
        int right = arr.length-1;

        while (left<right) {
            int currentSum = arr[i] + arr[left] + arr[right];
            if (currentSum == targetSum){
                System.out.println("Elements found :::");
                System.out.println(" "+ arr[i]+ " "+arr[left] + " "+arr[right]);
                
                right--;
                left++;

            } else if (targetSum > currentSum) {
                left++;

        } else if (targetSum < currentSum) {
            right--;
    

       }
    }}
}
    // Time = O(n2) Space = O(n)
    public static void findTriplet2(int [] arr, int targetSum){
        for (int i = 0; i < arr.length -2; i++){
            int requiredSum = targetSum - arr[i];
            HashSet<Integer> visited = new HashSet<>();    
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j] + ", " + (requiredSum - arr[j]));
                if (visited.contains(requiredSum - arr[j])) {
                    System.out.println("Triplet found: " + arr[i] + ", " + arr[j] + ", " + (requiredSum - arr[j]));
                }
                visited.add(arr[j]);
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 3, 5};
        int targetSum = 11;
        //findTriplet(arr, targetSum);
        findTriplet2(arr, targetSum);
    }
        
            

}
