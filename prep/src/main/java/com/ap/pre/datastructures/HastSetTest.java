package com.ap.pre.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HastSetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Atul");
        set.add("Pundir");
        set.add("Test");

        System.out.println(set);

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        boolean b =   map.put(1, "One")== null;
        boolean b2 =  map.put(2, "two")== null;
        boolean b3 =  map.put(2, "two")== null;

        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);
    }

}
