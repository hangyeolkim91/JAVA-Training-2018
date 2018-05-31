package com.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test5 {
	public static void main(String[] args) throws IOException{
		
		// 이름 , 국어, 영어점수, 총점 계산

		// 1. 선언

		String name;
		int kor,eng,tot;
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		// java.lang 은 기본적으로 vm이  import 해놓음 -> System.in을 import안해도 되는 이유
		
		// 2. 입력

		System.out.print("이름? ");
		name = br.readLine();

		System.out.print("국어점수? ");
		kor = Integer.parseInt(br.readLine());

		System.out.print("영어점수? ");
		eng = Integer.parseInt(br.readLine());

		//System.out.println("이름 : " + name + " 국어점수 : " + kor + " 영어점수: " + eng );

		// 3. 연산

		tot = kor + eng;

		// 4. 출력

		//System.out.println("총점 : "  + tot);
		System.out.printf(" 이름 : %s  총점 : %d  \n", name, tot);

	}
}
