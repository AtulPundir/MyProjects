package com.ap.pre.datastructures.mapsandsets;

import java.util.HashSet;

/*Few important features of HashSet are: 

Implements Set Interface.
The underlying data structure for HashSet is Hashtable.
As it implements the Set Interface, duplicate values are not allowed.
Objects that you insert in HashSet are not guaranteed to be inserted in the same order. Objects are inserted based on their hash code.
NULL elements are allowed in HashSet.
HashSet also implements Serializable and Cloneable interfaces.*/

public class SetOrder {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		int i =1;
		while(i <101) {
			set.add(i);
			i++;
		}
		
		System.out.println(set);

	}

}
