package com.class5;

/*
 * final을 사용하는 세 가지 경우
 * 
 * 1. 멤버변수를 상수로 선언할때
 * 2. method :  Override가불가
 * 3. class : 상속이 불가
 */

//final class Test{
class Test{
	
	public static final double PI; // 상수
	
	static{
		PI = 3.141592;
	}
	
	public double area;
	
	//Override 불가
	public final void write(String title){
		System.out.println(title + " : "+area);
	}
	
	
}


public class Test6 extends Test{

	/*public void write(String title){ 불가능
		
	}*/
	
	public void circleArea(int r){
		area = (double) r*r*PI;
	}

	
	public static void main(String[] args) {

		Test6 ob = new Test6();
		
		ob.circleArea(10);
		ob.write("Circle");
		
	}

}
