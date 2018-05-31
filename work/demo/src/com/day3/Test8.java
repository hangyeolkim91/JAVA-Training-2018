package com.day3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Test8 {
	public static void main(String[] args) throws IOException {

		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		

		int su, sum;
		//String ch;
		char ch;

		while(true){

			sum = 0;
			//ch = "";
			do{
				System.out.print("수입력?");
				su = Integer.parseInt(br.readLine()); // 100 CRLF
			}while( su <1 || su > 5000);

			for(int i=1; i<= su ; i++){
				sum += i;

			}
			System.out.println("1 ~ " + su + "까지의 합: " + sum);

			System.out.print("계속하시겠습니까?[y/n]");

			ch = (char)System.in.read(); // y CRLF 일때 y 하나만 읽어 온다..
			

			if( ch != 'y' && ch != 'n'){
				System.out.println("종료합니다..");
				break;
			}
			
			System.in.skip(2); // CRLF 를 지우지 않으면 다음 25행에서 CRLF가 입력됨 -> 빈 문자열이 su에 입력되어 에러 발생

			/*ch = sc.next();

			if( !ch.equalsIgnoreCase("y") ){
				break;
			}
			*/

			
		}//end..while
		



	}//end..main
}
