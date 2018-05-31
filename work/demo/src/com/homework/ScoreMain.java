package com.homework;


/*
 * [문제2]
 * 인원수를 입력 받아 인원수만큼 과목별 점수를 입력하고 각 과목별 판정을 하시오
 * 인원수 : 2
 * 1번째 이름 : 전지현
 * 국어 ? : 100
 * 영어 ? : 100
 * 수학 ? : 100
 * 
 * 1번째 이름 : 옥주현
 * 국어 ? : 80
 * 영어 ? : 80
 * 수학 ? : 80
 * 
 * 전지현 100(수) 100(수) 100(수) 300 100
 * 옥주현  80(우)  80(우)  80(우) 240 80
 */

public class ScoreMain {

	public static void main(String[] args) {

		Score sc = new Score();
		sc.set();
		sc.input();
		sc.printGrade();
	}

}
