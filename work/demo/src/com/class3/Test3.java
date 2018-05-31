package com.class3;

public class Test3 {
	
	int a =5;
	
	//초기화 블럭
	{
		System.out.println("초기화 블럭 : a " + a);
		a=10;
		System.out.println("초기화 블럭 : a " + a);
	}
	
	static int b;
	
	// static 초기화 블럭
	static{
		b = 10;
		System.out.println("static 초기화 블럭 b : " +b);
		
	}
	
	// 상수
	final int C;
	
	
	public Test3(){
		
		System.out.println("생성자 ...");
		
		C = 100;
		
		System.out.println("상수 C : " + C );
	}

	public static void main(String[] args) {

		Test3 ob1 =new Test3();
		System.out.println("\n------------------------------------");
		Test3 ob2 =new Test3();
	}

}
