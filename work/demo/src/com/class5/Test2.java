package com.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Test2 {

	public static void main(String[] args) throws IOException {

		//Calendar를 사용하여 만년 달력 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println("년 월 입력?[2018-04]");
		String yearMonth = br.readLine();
		
		String[] ym = yearMonth.split("-");
		int year = Integer.parseInt(ym[0]);
		int month = Integer.parseInt(ym[1]);
		
		//System.out.println(year+ " " + month);
		
		cal.set(year, month-1, 1);
		
		
		int week = cal.get(Calendar.DAY_OF_WEEK) -1;
		int end = cal.getActualMaximum(Calendar.DATE);
		
		//System.out.println(week + " " + end);
		
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");

		// 특정 요일부터 시작하도록 공백지정
		for(int i=0; i<week; i++)
			System.out.print("    ");


		// 해당 월의 날짜를 출력
		for(int i=1; i<=end; i++){
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
