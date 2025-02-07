package com.ap.pre.datastructures.mapsandsets;

//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetOrDefaultHashmap {

    public static void main(String[] args) {
        //Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map = new LinkedHashMap<>();

        String str = "aabbcdeff";


        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1 );
        }

        for (char c : map.keySet()){

            System.out.println(c + ":"+ map.get(c));
        }

        
    }

}
