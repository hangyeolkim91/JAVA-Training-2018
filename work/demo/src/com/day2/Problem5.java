package com.day2;

import java.util.Scanner;
class Problem5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("이름 과목1 과목2 과목3?");

		String name;
		int sub1, sub2, sub3;
		int totalScore, avgScore;
		String result="";

		name = sc.next();
		sub1 = sc.nextInt();
		sub2 = sc.nextInt();
		sub3 = sc.nextInt();

		totalScore = sub1+sub2+sub3;
		avgScore = totalScore/3;

		if( avgScore <60 ){
			result = "불합격";
		}else if ( sub1<40 || sub2<40 || sub3<40){
			result ="과락";
		}else{
			result = "합격";
		}
		
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + totalScore +", 평균 : " + avgScore + ", 판정 : " + result); 
	}
}
