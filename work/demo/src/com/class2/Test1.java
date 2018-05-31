package com.class2;

/*
 * this : ME, 자기자신(class 의 이름 = Circle)
 */

class Circle{
	
	private int r; // 정보의 은닉(캡슐화)
	private final double pi = 3.14;
	
	// 변수 초기화 메소드 ( 초기화 때 this를 많이 씀 ) 
	
	public void setData(int r){ //setData(int r, Circle this) 내부적으로 작동시 
		this.r = r;
	}
	
	public double area(){ // area(Circle this);
		return r*r*pi;
	}
	
	public void write(double a){ // wirte(double a, Circle this)
		System.out.println("반지름 : " + r);
		System.out.println("넓이 : " + a);
	}
	
}

public class Test1 {

	public static void main(String[] args) {

		Circle ob1 = new Circle();
		
		ob1.setData(10);          // setData(10,ob1);
		double r = ob1.area();    // area(ob1);
		ob1.write(r);             // write(r, ob1);
		
		ob1.setData(200);
		r = ob1.area();
		ob1.write(r);
	}

}
