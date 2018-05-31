package com.day2;

import java.util.ArrayList;
import java.util.Scanner;

class Test7 {

	public static void main(String[] args) {

		// 세 개의 수를 입력받아 작은 순에서 큰 순 으로 출력
		// 세 개의 수? 5 3 7
		// 결과 : 3 5 7

		Scanner sc = new Scanner( System.in );//.useDelimiter("\\s*,\\s*"); 3,5,6(x) | 3,5,6,(o)
		int n1, n2, n3 , temp;

		System.out.print("세 개의 숫자? ");


		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();


		
		int[] ar = new int[3];
		ar[0] = n1;
		ar[1] = n2;
		ar[2] = n3;

		for( int i = 0 ; i<3; i++){

			for(int j=i; j<3; j++){
				if( ar[i] > ar[j] ){
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		System.out.println(ar[0] + " " + ar[1] + " " + ar[2]);

		

		if( n1 > n2 ){
			temp = n2;
			n2 = n1;
			n1 = temp;
		}

		if( n1 > n3 ){
			temp = n1;
			n1 = n3;
			n3 = temp;
		}

		if( n2 > n3 ){
			temp = n3;
			n3 = n2;
			n2 = temp;
		}


		System.out.println( n1 + " " + n2 + " " + n3);


	}
}
