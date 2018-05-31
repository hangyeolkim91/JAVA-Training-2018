package com.day5;

import java.util.Random;
import java.util.Scanner;

public class Hw2 {

	public static void main(String[] args) {

		/*2. 1~10사이의 난수를 발생시켜 발생시킨 난수를 3번안에 알아 맞추는 게임
		   (3번안에 알아맞추지 못하면 발생된 난수를 출력)

		예)
		정수입력?[1번째기회] : 3
		틀렸어요!!
		정수입력?[2번째기회] : 5
		틀렸어요!!
		정수입력?[3번째기회] : 7
		틀렸어요!!

		정답은 2입니다

		계속할래?[Y/N] : 
		------------------------------
		정수입력?[1번째기회] : 7
		틀렸어요!!
		정수입력?[2번째기회] : 4
		틀렸어요!!
		정수입력?[3번째기회] : 9
		맞았어요!!

		정답은 9입니다

		계속할래?[Y/N] : */
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int number = rd.nextInt(10)+1;
			int input = 0;
			String cmd = "";
			
			for(int i=0; i<3; i++){
				System.out.print("정수입력?["+(i+1)+"번째 기회!]");
				input = sc.nextInt();
				if( number == input){
					System.out.println("맞았어요!!");
					break;
				}else
					System.out.println("틀렸어요!!");
			}
			
			System.out.println("\n정답은 " + number + "입니다.");
			
			System.out.print("\n계속할래?[y/n]");
			
			cmd = sc.next();
			if( !cmd.equalsIgnoreCase("y") ){
				
				break;
			}
			System.out.println("---------------------------------");
		}
		

	}

}
