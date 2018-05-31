package com.class3;


class Rect{
	private int w,h;
	
	//기본 생성자
	public Rect(){
		
	}
	
	// 오버로딩된 생성자
	public Rect(int w, int h){
		this.w = w;
		this.h = h;
	}
	
	// 초기화 메소드
	public void set(int w, int h){
		this.w = w;
		this.h = h;
	}
	
	public int area(){
		return w*h;
	}
	public int length(){
		return(w+h)*2;
	}
	
	public void print(int a){
		
		System.out.println("가로 : "+w);
		System.out.println("세로 : "+h);
		System.out.println("넓이 : "+a);
	}
	
	public void print(int a , int l){
		
		System.out.println("가로 : "+w);
		System.out.println("세로 : "+h);
		System.out.println("넓이 : "+a);
		System.out.println("둘레 : "+l);
		
	}
}

public class Test2 {

	public static void main(String[] args) {

		Rect ob1 = new Rect();
		ob1.set(10, 20);
		int a = ob1.area();
		int l = ob1.length();
		
		ob1.print(a);
		ob1.print(a,l);
		
		Rect ob2 = new Rect(100,200);
		
		a = ob2.area();
		l = ob2.length();
		
		ob2.print(a);
		ob2.print(a,l);
		
		ob2.set(11, 22);
		
		a = ob2.area();
		l = ob2.length();
		
		ob2.print(a);
		ob2.print(a,l);
		
	}

}
