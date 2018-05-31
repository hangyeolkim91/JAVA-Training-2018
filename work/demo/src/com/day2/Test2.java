package com.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test2 {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader( new InputStreamReader ( System.in ) ) ;

		int num1, num2;
		
		System.out.print("첫번째 수?");
		num1 = Integer.parseInt(br.readLine());

		System.out.print("두번째 수?");
		num2 = Integer.parseInt(br.readLine());

		System.out.printf("%d + %d = %d \t", num1, num2, num1+num2);
		System.out.printf("%d - %d = %d \n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d \t", num1, num2, num1*num2);
		System.out.printf("%d / %d = %g \n", num1, num2, (double)num1/num2);
		System.out.printf("%d %% %d = %d \n", num1, num2, num1%num2);

		
		System.out.println("num1 > num2 : " + (num1>num2)); // true or false
		System.out.println("num1 < num2 : " + (num1<num2)); // true or false
   
		

		String str;

		// 삼항 연산자

		str = num1%2 == 0 ? "짝수" : "홀수";

		str = num1>0 ? "양수" : (num1<0 ? "음수" :"영");

		// a &&(and) b , a ||(or) b
		str = num1%4 == 0 && num1%100 != 0 || num1%400 == 0 ? "윤년" : "평년";

		System.out.println(str);
	}

}
