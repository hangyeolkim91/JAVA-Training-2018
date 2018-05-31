package com.day2;

import java.util.Scanner;

class Problem2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print(" 두 개의 정수?");

		int n1, n2;
		n1 = sc.nextInt();
		n2 = sc.nextInt();

		if( n1 >= n2 )
			System.out.println( "큰숫자 : " + n1 + " 작은 숫자: " + n2 );
		else
			System.out.println( "큰숫자 : " + n2 + " 작은 숫자: " + n1 );
	}
}
