package com.day4;

import java.util.Scanner;

public class Hw3 {

	public static void main(String[] args) {
		
		//3.1-2+3-4+5-6+7-8+9-10
		
		Scanner sc = new Scanner(System.in);
		
		int n, sum=0;
		
		System.out.print("정수?");
		
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++){
			if( i%2 == 0){
				sum -=i;
			}else{
				sum+=i;
			}
		}
		System.out.println("결과 : " +sum);

	}

}
