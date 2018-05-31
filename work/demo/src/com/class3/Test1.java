package com.class3;

import java.util.Scanner;

// 생성자
// 메모리 할당을 받을 때 사용
// 변수 초기화시 사용

/*
 *  class의 이름과 동일
 *  리턴값이 없기 때문에 property가 없다.
 *  중복 정의가 가능 ( overloading )
 *  제일 선두에서 한번만 호출 가능
 */

public class Test1 {
	
	private int x;
	
	//기본 생성자
	
	public Test1(){
		
		this(20); // 선두에서 한번만
		
		System.out.println("인수가 없는 생성자");
		x = 10;
		System.out.println("x : " + x);
	}
	
	public Test1(int x){
		
		//this(); 오버로딩된 생성자에서 기본생성자 호출 가능
		
		System.out.println("인수가 있는 생성자");
		this.x = x;
		System.out.println("x : " + x);
	}
	
	public void setData(int x){
		this.x = x;
		System.out.println("x : " + x);
	}

	public static void main(String[] args) {
		
		Test1 ob = new Test1();
		//ob.setData(5);
		Test1 ob2 = new Test1(100);
		
		Scanner sc = new Scanner(System.in);// DI, 의존성 주입
		
		

	}

}
