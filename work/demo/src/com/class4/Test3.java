package com.class4;


//String은 class 이다 ( 자료형이 아니다 )

public class Test3 {

	public static void main(String[] args) {

		String ob1="Seoul";
		String ob2 = "Seoul";
		String ob3 = new String("Seoul");
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));
		System.out.println("ob1 == ob3 : "+ (ob1 == ob3));
		System.out.println("ob1.equals(ob3) : "+ ob1.equals(ob3));
		
		
		ob2 = "korea";
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));
		
		
		ob2 = "japan";
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));
		
		ob2 = "Seoul";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));
		
		System.out.println(ob2);
		System.out.println(ob2.toString());
		
		/*
		 * 처리하는 데이터는 방대하고 사용 빈도는
		 * 높기 때문에 데이터는 heap영역에 저장하고
		 * 사용하는 방법은 자료형처럼 사용한다. 
		 */
	}

}
