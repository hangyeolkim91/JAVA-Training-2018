package com.class1;

import com.day6.TestCom;

public class Test1 {

	public static void main(String[] args) {

		TestCom tc = new TestCom();
		TestCom tc1 = new TestCom();
		
		//System.out.println(System.in.available());
		
		tc.input();
		tc1.input();
		
		//System.out.println(System.in.available());
		
		int a = tc.area();
		int l = tc.length();
		tc.print(a, l);
		
		//------------------------
		
		a = tc1.area();
		l = tc1.length();
		tc1.print(a, l);
		
		System.out.println("tc.w: " + tc.w + " tc.h : " + tc.h);
		System.out.println("tc1.w: " + tc1.w + " tc1.h : " + tc1.h);
	}

}
