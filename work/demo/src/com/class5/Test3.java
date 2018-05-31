package com.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Test3 {

	public static void main(String[] args) throws IOException {

		//  오늘로 부터 x일 후를 년 월 일 요일 로 출력
		// 현재 : 2018년 5월 30일 수
		// 100일 후 : yyyy-mm-dd week
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calendar cal = Calendar.getInstance();
		
		String[] week = {"일","월","화","수","목","금","토"};
		
		String startDay;
		
		System.out.println("시작일?[yyy-mm-dd]");
		
		startDay = br.readLine();
		
		String[] startYMD = startDay.split("-");
		int[] startYmdInt = new int[3];
		
		for(int i=0; i<3; i++){
			startYmdInt[i] = Integer.parseInt(startYMD[i]);
		}
		
		cal.set(startYmdInt[0], startYmdInt[1]-1, startYmdInt[2]);
		
		int startWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		
		
		System.out.println(" 몇 일 ? ");
		String xDay = br.readLine();
		
		System.out.printf("현재 : %tF %s\n", cal, week[startWeek-1]);
		
		int x = Integer.parseInt(xDay);
		x--;
		cal.add(Calendar.DATE, x);
		int endWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		
		System.out.printf("%d일 째 : %tF %s", (x+1), cal, week[endWeek-1]);
	}

}
