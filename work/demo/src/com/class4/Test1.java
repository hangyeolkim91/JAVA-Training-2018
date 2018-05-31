package com.class4;

class A{
	public int x;
	
	// A의 부모는 java.lang.Object다
	public A(){
		
	}
	
	public A(int x){
		this.x = x;
	}
	
	public void print(){
		System.out.println("x : "+ x);
	}
}

class B extends A {
	
	public int y = 20;
	
	public B(){
		super();
	}
	public B(int x){
		super(x);
	}
	
	public void write(){
		System.out.println("y : "+ y);
	}
}

public class Test1 {

	public static void main(String[] args) {

		B ob = new B();
		
		B ob1 = new B(100);
		
		ob.write();
		ob.print();
		
		ob1.write();
		ob1.print();
	}

}
