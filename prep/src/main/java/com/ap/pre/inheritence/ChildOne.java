package com.ap.pre.inheritence;

public class ChildOne extends ParentClass {
	
	static {
		System.out.println("Static Block of CHILDONE");
	}
	
	ChildOne(){
		System.out.println("Constructor of CHILDONE");
	}

	public static void main(String[] args) {
		ParentClass p = new ParentClass();
		ParentClass p2 = new ChildOne();
		ChildOne c = new ChildOne();
		p.methodOne();
		System.out.println("===== CALL ONE ENDED ======");
		p2.methodOne();
		p.methodHiding();
		p2.methodHiding();
		c.methodHiding();

	}
	
	public void methodOne(){
		System.out.println("MethodOne of CHILD");
	}
	
	public void exclusiveChildOne() {
		System.out.println("Exclusive method of ChildOne");
	}
	
	public static void methodHiding() {
		System.out.println("Static method in Child");
	}

}
