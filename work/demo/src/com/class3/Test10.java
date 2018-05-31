package com.class3;

class SuperClass{
	private String title;
	protected double area;
	
	public SuperClass(){
		
	}
	
	public SuperClass(String title){
		this.title = title;
	}
	
	public void write(){
		System.out.println(title + ": "+ area);
	}
	public void setter(String title){
		this.title = title;
	}
}

class Circle extends SuperClass{
	
	private int r;
	protected static final double PI=3.14;
	
	public Circle(int r ){
		//super("원");
		super.setter("원");
		this.r = r;
	}
	
	public void circleArea(){
		area = r*r*PI;
	}

	@Override
	public void write() {
		super.write();
	}
	
}

class RectC extends SuperClass{
	
	private int w,h;
	
	public void rectArea(int w, int h){
		this.w = w;
		this.h = h;
		area = w*h;
	}
	
	// method override
	public void write(){
		System.out.println("가로 : "+ w);
		System.out.println("세로 : "+ h);
		System.out.println("넓이: " + area);
	}
}



public class Test10 {

	public static void main(String[] args) {
		
		Circle ob1 = new Circle(10);
		ob1.circleArea();
		ob1.write();
		
		System.out.println("---------------------");
		
		RectC ob2 = new RectC();
		
		ob2.rectArea(10, 20);
		
		ob2.write();
		
		//ob2.print();

	}

}
