package com.ap.pre.datastructures.mapsandsets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapVsHashSet {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		Set<String> set = new HashSet<String>();
		
		//Adding
		map.put(1, "One");
		set.add("One");
		
		//GET
		
		System.out.println(map.get(1));
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		//System.out.println(set.);
	}
}
