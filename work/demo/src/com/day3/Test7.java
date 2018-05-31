package com.day3;

import java.util.Scanner;


public class Test7 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		System.out.println("1~3 이내의 수?");// 1, 2, 3
		
		n = sc.nextInt();
		
		switch(n){
		
		case 3:
			System.out.println("***");
			break;
			
		case 2:
			System.out.println("**");
			break;
			
		case 1:
			System.out.println("*");
			break;
			
		default:
			System.out.println("숫자입력오류!");
			
			
		}
		
		
	}

}
