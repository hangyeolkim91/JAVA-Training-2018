package com.class3;

/*
 *  상속( 부모가 자식한테 )
 *  
 *  1. 부모의 것 = 자식의 것
 *  2. private으로 선언한 것 = 부모의 것
 *  3. protected로 선언한 것은 상속이 가능
 *  4. 자식의 것 = 자식의 것
 *  5. 같은 객체를 가지고 있으면 자신의 것을 쓴다.
 *  
 */

class TestB{
	
	private String title;
	//private int area;
	protected int area;
	
	public void set(String title){
		this.title = title;
		//this.area = area;
	}
	
	public void print(){
		System.out.println(title+ ": "+ area);
	}
	
}

class RectB extends TestB{
	private int w,h;
	
	public RectB(int w, int h){
		this.w=w;
		this.h=h;
	}
	
	public void reactArea(){
		//int a = w*h;
		area = w*h;
		set("사각형");
		
	}
}

public class Test9 {

	public static void main(String[] args) {

		RectB ob = new RectB(10,20);
		ob.reactArea();
		ob.print();
	}

}
