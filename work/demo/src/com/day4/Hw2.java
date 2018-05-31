package com.day4;

import java.util.Scanner;

public class Hw2 {

	public static void main(String[] args) {

		//2.1에서 100까지 수의 홀수의 합, 짝수의 합, 전체의 합
		
		Scanner sc = new Scanner(System.in);
		
		
		int n, sum=0, sumOfOdd=0, sumOfEven=0;
		
		System.out.print("정수?");
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++){
			sum +=i;
			if( i%2 == 0){
				sumOfEven +=i;
			}else{
				sumOfOdd +=i;
			}
		}
		
		System.out.println("전체 합 :" + sum + " 홀수의 합: " + sumOfOdd + " 짝수의 합 : " + sumOfEven);
		
		
	}

}
