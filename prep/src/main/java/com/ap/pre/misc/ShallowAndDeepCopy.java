package com.ap.pre.misc;


class ShallowCopy {
	String name;
}

class DeepCopy  implements Cloneable{
	String name;
}


public class ShallowAndDeepCopy implements Cloneable {
	
	int x; 
	ShallowCopy shallowCopyObj;
	DeepCopy deepCopyObj;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowAndDeepCopy obj = new ShallowAndDeepCopy();
		obj.x = 10;
		obj.shallowCopyObj = new ShallowCopy();
		obj.deepCopyObj = new DeepCopy();
		obj.shallowCopyObj.name = "Shallow";
		obj.deepCopyObj.name = "Deep";
		
		
		ShallowAndDeepCopy shallowCopy = obj;

		System.out.println(obj.x);
		System.out.println(obj.shallowCopyObj.name);
		System.out.println(obj.deepCopyObj.name);
		System.out.println(shallowCopy.x);
		System.out.println(shallowCopy.shallowCopyObj.name);
		System.out.println(shallowCopy.deepCopyObj.name);
		
		
		shallowCopy.x = 20;
		shallowCopy.shallowCopyObj.name = "Shallow Copy";
		
		System.out.println();
		System.out.println(obj.x);
		System.out.println(obj.shallowCopyObj.name);
		System.out.println(obj.deepCopyObj.name);
		System.out.println(shallowCopy.x);
		System.out.println(shallowCopy.shallowCopyObj.name);
		System.out.println(shallowCopy.deepCopyObj.name);
		
		//In the above code it can be seen that the initial obj's reference is copied to shallowCopy object.
		//Whatever change is made in any of the object will reflect in both as they are referring to the same object
		
		
		
		//NOT A DEEP COPY
		ShallowAndDeepCopy deepCopy = (ShallowAndDeepCopy) obj.clone();
		
		deepCopy.x = 100;
		deepCopy.deepCopyObj.name = "Deep Copy";
		//deepCopy.deepCopyObj = deepCopyObj.clone();
		
		System.out.println();
		System.out.println(obj.x);
		System.out.println(obj.shallowCopyObj.name);
		System.out.println(obj.deepCopyObj.name);
		System.out.println(shallowCopy.x);
		System.out.println(shallowCopy.shallowCopyObj.name);
		System.out.println(shallowCopy.deepCopyObj.name);
		System.out.println(deepCopy.x);
		System.out.println(deepCopy.shallowCopyObj.name);
		System.out.println(deepCopy.deepCopyObj.name);
		
		
	}

}
