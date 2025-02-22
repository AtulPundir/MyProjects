package com.ap.pre.leetcode;


import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

//MEDIUM
public class A347TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        int [] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
        
        for (int x : map.keySet()){
            int currentValue = map.get(x);

            if (currentValue > largest){
                if (slargest == Integer.MIN_VALUE){
                    slargest = currentValue;
                    result[1] = x;
                }
                largest = currentValue;
                result[0] = x;
                
                
            } else if (largest == slargest){
                slargest = currentValue;
                result[1] = x;
            }
            
            
            else if (currentValue > slargest) {
                slargest = currentValue;
                result[1] = x;
            }
          
        }

        return result;
        
    }


    public static int[] topKFrequent2(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets (array of lists)
        List<Integer>[] buckets = new List[nums.length + 1]; // Max frequency ≤ nums.length
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Step 3: Collect top k elements from highest frequency bucket
        List<Integer> resultList = new ArrayList<>();
        for (int i = nums.length; i > 0 && resultList.size() < k; i--) {
            if (buckets[i] != null) {
                resultList.addAll(buckets[i]);
            }
        }

        // Convert to array
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int[] topKFrequent3(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort elements by frequency
        List<Integer> sortedKeys = new ArrayList<>(freqMap.keySet());
        sortedKeys.sort((a, b) -> freqMap.get(b) - freqMap.get(a)); // Descending order

        // Step 3: Collect top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedKeys.get(i);
        }

        return result;
    }

    public static int[] topKFrequent4(int[] nums, int k) {
        // Step 1: Count frequencies using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min Heap (PriorityQueue) to store k most frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(freqMap::get) // Compare elements by their frequency
        );

        for (int key : freqMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 3: Extract elements from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
    
    //MAIN
    public static int[] topKFrequent5(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max) max = n;
            if (n < min) min = n;
        }
        int[] freq = new int[max - min + 1];
        List<Integer>[] freqList = new ArrayList[nums.length + 1];
        
        //Getting Frequency count
        int[] result = new int[k];
        for (int n : nums) {
            freq[n - min]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (freqList[freq[i]] == null) {
                    freqList[freq[i]] = new ArrayList<>();
                }
                freqList[freq[i]].add(i + min);
            }
        }

        for (int i = freqList.length - 1; i >= 0; i--) {
            if(freqList[i] != null) {
                for (Integer x : freqList[i]) {
                    if (k < 1) return result;
                    result[--k] = x;
                }
            }
        }
        return result;
    }


    public static int[] topKFrequent6(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max) max = n;
            if (n < min) min = n;
        }
        //max-min+1 gives the max total elemets that the list can have
        int[] freq = new int[max - min + 1];
        //List<Integer> freqList = new ArrayList<>(nums.length + 1);
        
        //Getting Frequency count
        int[] result = new int[k];
        for (int n : nums) {
            freq[n - min]++;
        }

        List<Integer> freqList = new ArrayList<>(Collections.nCopies(freq.length, 0));

        for (int i = 0; i < freq.length; i++) {
            int x = freq[i];
            if (x > 0) {
                freqList.add((i + min),x);
            }
        }
        
        List<Integer> tempList = new ArrayList<>(freqList); 
        for (int i = 0; i < k; i++) {
            int maxIndex = -1;
            int maxFreq = -1;

            // Find the index with the highest frequency (while preserving order)
            for (int j = 0; j < tempList.size(); j++) {
                if (tempList.get(j) > maxFreq) {
                    maxFreq = tempList.get(j);
                    maxIndex = j;
                }
            }

            if (maxIndex != -1) {
                result[i] = maxIndex; // Store the location (index)
                tempList.set(maxIndex, -1); // Mark selected index so it's not picked again
            }
        }

        return result;
    }


    public static int[] topKFrequent7(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Find the range of numbers (min and max)
        for (int n : nums) {
            if (n > max) max = n;
            if (n < min) min = n;
        }

        // Array to store frequencies (normalized by shifting with 'min')
        int[] freq = new int[max - min + 1];

        // Calculate frequency
        for (int n : nums) {
            freq[n - min]++;
        }

        // Use a List<Integer> to store frequencies based on index
        List<Integer> freqList = new ArrayList<>(Collections.nCopies(freq.length, 0));

        for (int i = 0; i < freq.length; i++) {
            freqList.set(i, freq[i]); // Update frequency list
        }

        // Find the top K elements
        int[] result = new int[k];
        List<Integer> tempList = new ArrayList<>(freqList);

        for (int i = 0; i < k; i++) {
            int maxIndex = -1;
            int maxFreq = -1;

            for (int j = 0; j < tempList.size(); j++) {
                if (tempList.get(j) > maxFreq) {
                    maxFreq = tempList.get(j);
                    maxIndex = j;
                }
            }

            if (maxIndex != -1) {
                result[i] = maxIndex + min; // Convert back to original number
                tempList.set(maxIndex, -1); // Mark as used
            }
        }

        return result;
    }


    
    public static void main(String[] args) {
        int [] nums =  {1,1,1,2,2,3};
        int k = 2;

        int [] res = topKFrequent7(nums, k);

        for (int x : res){
            System.out.println( x);
        }

        int [] nums2 = {-1,-1};
        k =1;
        res = topKFrequent7(nums2, k);
        for (int x : res){
            System.out.println( x);
        }
       
    }
}


/*
 * 
 * 
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 * 
 * 
 */
