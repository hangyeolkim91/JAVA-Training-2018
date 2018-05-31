package com.day3;

import java.util.Scanner;
import java.io.IOException;

class Test3 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int su, sum;
		//String ch;
		char ch;

		while(true){

			sum = 0;
			//ch = "";
			do{
				System.out.print("수입력?");
				su = sc.nextInt();
			}while( su <1 || su > 5000);

			for(int i=1; i<= su ; i++){
				sum += i;

			}
			System.out.println("1 ~ " + su + "까지의 합: " + sum);

			System.out.print("계속하시겠습니까?[y/n]");

			ch = (char)System.in.read();

			if( ch != 'y' && ch != 'n'){
				System.out.println("종료합니다..");
				break;
			}

			/*ch = sc.next();

			if( !ch.equalsIgnoreCase("y") ){
				break;
			}
			*/

			
		}//end..while
		



	}//end..main
}
