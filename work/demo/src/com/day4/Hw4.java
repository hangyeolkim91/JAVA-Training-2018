package com.day4;

import java.util.Scanner;

public class Hw4 {
	
	public static void main(String[] agrs){
		
		//4. 1에서 100까지의 수중 3의 배수의 갯수
		
		Scanner sc = new Scanner(System.in);
		
		int n, multipleOfThree=0;
		
		System.out.print("정수?");
		
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++){
			if( i%3 == 0){
				multipleOfThree += 1;
			}
		}
		
		System.out.println("결과 : "+ multipleOfThree);
	}
}
