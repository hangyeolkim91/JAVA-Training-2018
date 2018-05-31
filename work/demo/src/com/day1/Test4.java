package com.day1;

import java.io.*;

class Test4{

	public static void main(String[] args) throws IOException {// Exception 가능, (ti)API 문서를 읽을 수 있는지를 체크하는 용도

		/*
		* System.in : 키보드를 통해 1byte 문자를 입력받음 (표준입력?)
		* InputStreamReader : System.in으로 입력받은 1byte문자를 2byte의 문자로 변경
		* BufferedReader : 버퍼(메모리)에 저장
		*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int r;
		double a,l;

		System.out.print("반지름? ");

		r = Integer.parseInt(br.readLine());

		a = r*r*3.14;
		l = 2*3.14*r;

		System.out.println("넓이 : " + a +" 둘레: " + l );

	}
}
