package com.day3;

import java.util.Scanner;


class Test2 {

	public static void main(String[] args) {
		//10보다 큰 수를 입력 받아 1부터 합계 구하기

		Scanner sc = new Scanner(System.in);

		int su, sum=0;

		do{
			System.out.print("10 보다 큰 수 입력?");
			su = sc.nextInt();

		}while( su <10);
/*
		for(int i=1; i<=su; i++){
			sum = sum + i;
		}
*/
		int i=0;
		while( i < su){
			i++;
			sum +=i;
		}
		System.out.println("결과: " + sum);
		

	}
}
