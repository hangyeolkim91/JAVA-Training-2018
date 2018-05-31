package com.day1;

class Test2{

	public static void main(String[] args) {

		// int : 정수형 자료형 
		int a = 20; // = 대입 연산자
		int b = 5;
		int c,d; // 쓰레기값

		System.out.println(a);
		System.out.println(b);
		//System.out.println(c); 쓰레기값은 볼 수 없다.

		c = a + b;
		System.out.println(c);

		d = a - b;
		System.out.println(d);

		b = 10;
		System.out.println(b);

		c = a + b;
		d = a - b;
		System.out.println(c); // 30

		System.out.println(a + " + " + b + " = " + c);

		System.out.printf( "%d+%d=%d\n", a,b,c);

		System.out.printf("%d - %d = %d\n" , a,b,d);
	}

}
