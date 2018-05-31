package com.class2;

import java.util.Scanner;

class Rect{
	
	private int w,h;
	
	public void set(int w, int h){
		
		this.w = w;
		this.h = h;
		
	}
	
	public int area(){
		return w*h;
	}
	public int length(){
		return (w+h)*2;
	}
	
	public void print(int a, double l){
		System.out.println("가로 : "+w);
		System.out.println("세로 : "+h);
		System.out.println("넓이 : "+a);
		System.out.println("둘레 : "+l);
	}
	
	// Method Overloading (중복 정의)
	// Method의 이름은 동일 하지만 매개변수의 갯수 혹은 데이터 타입이
	// 다르면 다른 Method로 인식한다.
	
	/*
	 * Overloading은
	 * 하나의 클래스 안에서 동일 작업을 하는 메소드의 이름을 
	 * 통일 시키기 위해 한다.
	 */
	
	public void print(){
		System.out.println("가로 : "+w);
		System.out.println("세로 : "+h);
	}
	
	public void print(int a){
		System.out.println("가로 : "+w);
		System.out.println("세로 : "+h);
		System.out.println("넓이 : "+a);
	}
	public void print(double l){
		System.out.println("가로 : "+w);
		System.out.println("세로 : "+h);
		System.out.println("둘레 : "+l);
	}
}

public class Test4 {

	public static void main(String[] args) {

		Rect rc = new Rect();
		int w,h;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로?");
		w = sc.nextInt();
		System.out.println("세로?");
		h = sc.nextInt();
		
		rc.set(w, h);
		int a = rc.area();
		double l = rc.length();
		
		rc.print(l);
		rc.print(a);
		
//		rc.print(a, l);
//		rc.write();
//		rc.areaWrite(a);
//		rc.lengthWrite(l);
		String str;
		
	}

}
