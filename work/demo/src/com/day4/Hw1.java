package com.day4;

import java.util.Scanner;

public class Hw1 {

	public static void main(String[] args) {
		
		//1. (1)+(1+2)+(1+2+3)+...+(1+2+3+...+10)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수?");
		
		int n = sc.nextInt();
		int sum=0;
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				sum +=j;
			}
		}
		System.out.println("합계 : "+sum);

	}

}
