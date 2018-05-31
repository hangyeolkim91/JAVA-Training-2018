package com.day2;

import java.util.Scanner;

class Problem1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner( System.in );

		System.out.print("Á¤¼ö?");
		int n = sc.nextInt();

		if( n%2 == 0 )
			System.out.println( "Â¦¼ö");
		else
			System.out.println("È¦¼ö");

	}
}
