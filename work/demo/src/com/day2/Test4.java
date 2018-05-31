package com.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test4{

	public static void main(String[] args) throws IOException {

		//Á¦¾î¹®
		// if, for, while, do~while, switch

		BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) ) ;

		int num = 0;
		String str = "";//null

		System.out.print("¼ö ÀÔ·Â?");

		num = Integer.parseInt(br.readLine());

/*
		if( num %2 == 0){
			str = "Â¦¼ö";
		}

		if( num%2 != 0 ){
			str = "È¦¼ö";
		}
*/

		if( num%2 == 0 ) {
			str = "Â¦¼ö";
		}else{
			str = "È¦¼ö";
		}


		System.out.println(str);
	}
}
