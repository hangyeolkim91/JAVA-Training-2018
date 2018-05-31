package com.class4;

/*
 * Wrapper 클래스
 * 기본 데이터(자료형)을 객체로 사용 할 수 있게 해줌
 * 데이터 타입 : boolenan , byte, char, short, int, long, double, float
 * 레퍼런스 타입 : Boolean , Byte, Character, Short, Integer, Long, Float, Double
 */

/*
 * Auto-Boxing(stack - > heap)
 * Auto-UnBoxing(heap -> stack)
 */


public class Test8 {

	public static void main(String[] args) {

		int n1=10;
		int n2 ;
		Integer num1;
		Integer num2 = new Integer(20);
		
		num1 = n1; // Auto-Boxing(stack - > heap)
		n2 = num2; // Auto-UnBoxing(heap -> stack)
		
		System.out.println(n1 + ":"+ num1);
		System.out.println(n2 + ":"+ num2);
	}

}
