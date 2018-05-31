package com.day6;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		// 주민번호 검색
		// index : 01234567890123
		// jumin : 941231-2053128
		// check : 234567 892345
		
		// sum = (9*2)+(4*3)+ ... + (2*5) 세로로 곱하여 더함 ( jumin, check)
		// sum = 11-sum%11
		// sum = sum%10
		// sum == 8( 주민번호 맨 끝 수 )
		
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		int[] check = {2,3,4,5,6,7, 8,9,2,3,4,5};
		int sum, chk;
		
		System.out.print("주민번호? [123456 - 1234567]");
		
		str = sc.next();
		
		if(str.length() != 14 ){
			System.out.println("입력 오류!!!");
			return; // main method를 빠져나감 (stop)
			
		}
		
		sum= 0;
		
		for(int i=0; i<12; i++){
			
			if(i>=6){
				
				sum += check[i]* Integer.parseInt(str.substring(i+1,i+2));
				
			}else{
				
				sum += check[i]* Integer.parseInt(str.substring(i,i+1));
			}
		}
		
		
		chk = 11 - sum%11;
		chk = chk%10;
		
		System.out.println(chk);
		
		if( chk == Integer.parseInt(str.substring(13))){
			System.out.println("정확한 주민번호!!");
		}else{
			System.out.println("틀린 주민 번호!!");
			
		}
	}

}

/*

String str = "seoul korea";

                012345678910
System.out.println(str.substring(0,3));
System.out.println(str.substring(6,8));
System.out.println(str.substring(6));
*/