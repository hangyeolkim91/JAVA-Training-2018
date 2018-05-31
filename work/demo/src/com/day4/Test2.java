package com.day4;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//배열
		//int num[] = new int[5];
		int[] num = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("다섯개의 정수?");
		
		for(int i=0; i<num.length; i++){
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<num.length; i++){
			System.out.println( "num[" + i + "] : " +num[i]);
		}
		
		/*num[3] = 400;
		
		System.out.println("num[3]: " + num[3]);
		
		int a = num[0];
		System.out.println(a);
		
		System.out.println(num.length);*/
		
	}

}
