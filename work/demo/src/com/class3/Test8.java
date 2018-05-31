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

class Test{
	
	private String title;
	private int area;
	
	public void set(String title, int area){
		this.title = title;
		this.area = area;
	}
	
	public void print(){
		System.out.println(title+ ": "+ area);
	}
	
}

class RectA extends Test{
	private int w,h;
	
	public RectA(int w, int h){
		this.w=w;
		this.h=h;
	}
	
	public void reactArea(){
		int a = w*h;
		set("사각형", a);
		
	}
}

public class Test8 {

	public static void main(String[] args) {

		RectA ob = new RectA(10,20);
		ob.reactArea();
		ob.print();
	}

}
