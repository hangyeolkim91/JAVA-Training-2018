package com.generic;

class Box<T>{
	private T t;
	
	public void set(T t){
		
		this.t = t;
	}
	
	public T get(){
		
		return t;
	}
}

public class Test1 {

	public static void main(String[] args) {

		Box<String> b = new  Box<String>();
		
		b.set("My age is ");
		
		//System.out.println(b.get());
		
		Box<Integer> b1 = new Box<Integer>();
		
		b1.set(39); 			// Auto Boxing   Wrapper class
		b1.set(new Integer(28));
		
		System.out.println(b.get()+ b1.get());
		
		Box b3 = new Box();
		b3.set(30);
		Integer i = (Integer) b3.get();
		System.out.println(i);
		
	}

}
