package com.ap.pre.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AATest {

    private final Map<Integer, Integer> map;
    private final ArrayList<Integer> list;
    private Random random;
    int index;
    int lastValue;
    

    AATest(){
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
       
    }

     public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
        
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        index = map.get(val);
        lastValue = list.get(list.size() - 1); 
        list.set(index, lastValue);
        list.remove(list.size() -1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
