package com.day2;

import java.util.Scanner;

class Test5{

	public static void main(String[] args) {

		// Scanner:  단락문자의 패턴을 사용해서 분류
		// 기본 패턴은 공백

		Scanner sc = new Scanner( System.in );

		String name;
		int kor;

		System.out.print("이름?");
		name = sc.next();

		System.out.print("국어?");
		kor = sc.nextInt();

		String pan;

		if(kor >= 90){
			pan = "수";
		}else if (kor >=80 ){
			pan = "우";
		}else if( kor >= 70){
			pan = "미";
		}else if (kor >= 60){
			pan = "양";
		}else{
			pan = "가";
		}

		System.out.println(name  +"\t"+ kor + "점: " + pan);
	}
}
