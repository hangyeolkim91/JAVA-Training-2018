package com.day4;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		//만년 달력

		Scanner sc = new Scanner(System.in);

		// 월별 날짜수를 저장

		int months[] = {31, 28, 31, 30, 31, 30 ,31, 31, 30, 31,30, 31};


		int y, m, nalsu=0, week;

		do{
			System.out.print("년도?");
			y = sc.nextInt();
		}while(y<1);

		do{
			System.out.print("월?");
			m = sc.nextInt();
		}while(m<1 || m>12);

		if( y %4 == 0 && y %100 !=0 || y %400==0){
			months[1] = 29;
		}

		nalsu = (y-1)*365 + (y-1)/4-(y-1)/100+(y-1)/400;

		//전월 m-1
		for(int i=0; i<m-1; i++){
			nalsu += months[i];
		}

		// y년 m월 1일까지의 날 수 
		nalsu += 1;

		week = nalsu%7; // 0~6



		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");

		// 특정 요일부터 시작하도록 공백지정
		for(int i=0; i<week; i++)
			System.out.print("    ");


		// 해당 월의 날짜를 출력
		for(int i=1; i<=months[m-1]; i++){
			System.out.printf("%4d",i);

			week++;
			if( week%7 == 0)
				System.out.println();
		}

		if( week %7 !=0)
			System.out.println();
		System.out.println("------------------------------");

	}

}
