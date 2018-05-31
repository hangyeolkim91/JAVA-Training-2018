package com.day3;

import java.util.Scanner;


class Test1 {

	public static void main(String[] args) {

		//loop (for, while, do~while)

		Scanner sc = new Scanner(System.in);

		int dan;

		System.out.print("원하는 단?");
		
		dan = sc.nextInt();

		// for 문 
		for (int i=1; i<=9; i++ ){
			System.out.println(dan+" * "+i +" = "+ dan*i);
			//System.out.printf("%d * %d = %d\n", dan, i , dan*i);
			
		}
		System.out.println("---------------------------");

		//while(최대값)

		int j=0;

		while(j <9){

			j++;
			System.out.println(dan+" * "+j +" = "+ dan*j);
			
		}
		System.out.println("---------------------------");

		// do ~ while

		int k=0;

		do{
			k++;
			System.out.println(dan+" * "+k +" = "+ dan*k);
		}while(k <9);

	}
}
