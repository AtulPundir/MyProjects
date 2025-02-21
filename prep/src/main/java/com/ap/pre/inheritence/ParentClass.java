package com.ap.pre.inheritence;

public class ParentClass {
	
	static {
		System.out.println("Static Block of PARENT");
	}
	
	ParentClass(){
		System.out.println("Constructor of PARENT");
	}

	public void methodOne(){
		System.out.println("MethodOne of PARENT");
	}
	public static void staticMethod(){
		System.out.println("Static Method of Parent");
	}
	private static void privateMethod(){
		System.out.println("Private Method of Parent");
	}
	
	public static void main(String[] args) {
		
	}
	
	public static void methodHiding() {
		System.out.println("Static method in Parent");
	}

}
