package com.ap.pre.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class A380InsertDeleteGetRandomAtOnComplexity {

    Set<Integer> set;
    Random random;


    public A380InsertDeleteGetRandomAtOnComplexity() {
        set =  new HashSet<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        return set.add(val);
        
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        if (set.size()>=1){
            List<Integer> list = new ArrayList<>(set);
            return list.get(random.nextInt(list.size()));
        }
        return 0;
    }

    public static void main(String[] args) {
        A380InsertDeleteGetRandomAtOnComplexity obj = new A380InsertDeleteGetRandomAtOnComplexity();
        boolean param_1 = obj.insert(1);
        System.out.println(param_1);
        
        boolean param_2 = obj.remove(2);
        System.out.println(param_2);
        
        boolean param_11 = obj.insert(2);
        System.out.println(param_11);
        
        int param_3 = obj.getRandom();
        System.out.println(param_3);

        boolean param_21 = obj.remove(1);
        System.out.println(param_21);
        
        boolean param_12 = obj.insert(2);
        System.out.println(param_12);
        
        int param_31 = obj.getRandom();
        System.out.println(param_31);
        
        
        
        
        
       
       
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

