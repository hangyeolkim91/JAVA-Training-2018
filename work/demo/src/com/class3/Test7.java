package com.class3;

import java.util.Calendar;

// Call by Value

/*
 *  stack 영역의 데이터가 heap영역으로 데이터 자체가 넘어감
 */

// Call by Reference

/*
 * 값을 넘길때 객체의 시작점 주소가 넘어감
 */

class Sub{
	public int x = 10;
	
	public void sub(int a ) {
		
		 x += a;
	}
}

public class Test7 {

	public static void main(String[] args) {

		Sub ob = new Sub();
		
		int a = 20;
		
		
		System.out.println("sub() method 실행 전 x : "+ob.x);
	
		ob.sub(a); // call by value
		
		System.out.println("sub() method 실행 후 x : "+ob.x);
		
		
		// Call by Reference
		Sub ob1;
		
		ob1 = ob;
		System.out.println("sub() method 실행 전 x : "+ob1.x);
		//ob1.sub(10);
		
		Calendar now = Calendar.getInstance();
		Calendar now2 = Calendar.getInstance();
		Calendar now3 = Calendar.getInstance();
		Calendar now4 = Calendar.getInstance();
		
		
	}

}
