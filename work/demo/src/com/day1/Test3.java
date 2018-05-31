package com.day1;

class Test3 
{
	public static void main(String[] args) 
	{
		int r = 10;
		float area, length; // 실수
		
		area = r * r * 3.14f;
		length = 2 * 3.14f * r;

		System.out.printf( "반지름: %d, 넓이 : %.2f\n", r,area);// %g 는 double형
		System.out.printf( "반지름: %d, 넓이 : %f\n", r,area);
		System.out.println( "area = " + area);
		System.out.println( "둘레 : " + length);// 62.800003 의 3은 이진수 계산시 나온 쓰레기값 
		
		System.out.println();
		//System.out.print(); error 반드시 매개변수가 필요한 함수
	}
}
