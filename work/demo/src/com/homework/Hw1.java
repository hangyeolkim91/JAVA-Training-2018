package com.homework;

import java.io.IOException;

/*
 * [문제1]
	System.in.read()만 사용해서 숫자를 입력받고
	입력받은 수까지의 합계를 구하시오
	
	조건
	1.BufferedReader X
	2.Scanner X
	
	모양
	수입력? 10
	1-10까지의 합: 55
 */

public class Hw1 {

	public static void main(String[] args) throws IOException {
		
		System.out.print("수입력?");

		/*char a= (char)System.in.read(); 
		
		String str="";
		
		while( a != '\r' ){
			str += a;
			a = (char)System.in.read();
			
		}
		System.out.println(str);
		
		
		
		
		int n;
		
		n = Integer.parseInt(str);
		
		int sum =0;
		for(int i=1; i<=n; i++){
			sum+=i;
		}
		System.out.println("합계 : " + sum);*/
		
		
		int a = System.in.read();
		int number=0;
		int sum=0;
		
		while( a !='\r'){
			
			number *= 10;
			
			number += (a-'0');
			
			a = System.in.read();
			
			
		}
		System.out.println(number);
		
		for(int i=1; i<=number; i++){
			sum+=i;
		}
		System.out.println("합계 : " + sum);
		
	}

}
