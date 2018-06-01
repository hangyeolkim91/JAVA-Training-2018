package com.class7;

/*
 * 내부 클래스
 * 중첩
 */

class Outer2{
	
	static int a=10;
	int b=20;
	
	public static class Inner2{
		
		int c =30;
		
		public void write(){
			System.out.println(a);
			//System.out.println(b);
			System.out.println(c);
			Outer2 out = new Outer2();
			System.out.println("out.b: " + out.b);
		}
	}
	
	public void print(){
		Inner2 ob = new Inner2();
		ob.write();
		
	}
}

public class Test3 {

	public static void main(String[] args) {
		
		Outer2 out = new Outer2();
		Outer2.Inner2 inner = new Outer2.Inner2();
		inner.write();
		out.print();

	}

}
