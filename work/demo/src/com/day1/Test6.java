package com.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class Test6 {

	public static void main(String[] args) throws IOException {
		
		// 밑변(w)과 높이(h)를 입력받아 삼각형의 넓이(a)구하기
		// 밑변? 10
		// 높이? 20
		// 넓이 : 15
		
		double w , h, a;

		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ) );
		
		System.out.print("밑변 ?");
		w = Double.parseDouble(br.readLine());
		System.out.print("높이 ?");
		h = Double.parseDouble(br.readLine());

		a = w * h / 2;
		/* 형변환
		* int w, h;
		* a = w * h / 2.0;
		* a = [(double) w ] * h / 2;
		*      w만 double로 바뀜
		*/

		System.out.println("넓이 : " + a);
	}
}