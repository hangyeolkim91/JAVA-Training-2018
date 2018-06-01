package com.class7;

/*
 * 내부클래스 (inner class)
 * Inner
 */

class Outer{
	
	static int a = 10;
	private int b = 20;
	
	public class Inner{
		
		int c= 30;
		
		public void write(){
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
		
		
	}
	public void print(){
		
		Inner in = new Inner();
		in.write();
	}
}

// Nested class
class A{
	
}

public class Test1 {

	public static void main(String[] args) {

		Outer out = new Outer();
		
		out.print();
	
		Outer.Inner inner = out.new Inner();
		
		inner.write();
		
	}

}
