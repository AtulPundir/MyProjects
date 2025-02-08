package com.ap.pre.datastructures.walmart;

public class FindMissingElementInArrray {

    private static int findMissing(int[] arr) {

        //int diff = 0;
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        System.out.println(diff);
        
        for (int i= 1; i < arr.length-1; i ++) {
            if((arr[i] - arr[i-1] != arr[i+1] - arr[i])){
                return arr[i] + diff;
            } else {
                diff = arr[i] - arr[i-1];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,6,7,9,11,12,13,14,15,17};
        System.out.println(arr.length);

        int x = findMissing(arr);

        System.out.println(x);
    }

}
