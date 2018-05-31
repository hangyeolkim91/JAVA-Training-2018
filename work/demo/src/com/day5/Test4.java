package com.day5;

import java.util.Arrays;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		// 10명 이내의 이름과 점수를 입력 받아
		// 석차 구하기

		Scanner sc = new Scanner(System.in);

		String[] name;
		int[] score,rank;
		int numOfPeople=0;

		while(numOfPeople <1 || numOfPeople >10){

			System.out.println("사람수?[1-10]");
			numOfPeople = sc.nextInt();
		}

		name = new String[numOfPeople];
		score = new int[numOfPeople];
		rank = new int[numOfPeople];

		for(int i=0; i<numOfPeople; i++){

			System.out.print((i+1)+"번째 이름? ");
			name[i] = sc.next();

			System.out.println("점수?");
			score[i] = sc.nextInt();

		}

		for( int i=0; i<numOfPeople; i++){
			rank[i]++;
		}



		for(int i=0; i<numOfPeople-1; i++){
			for(int j=i+1; j<numOfPeople; j++){

				if( score[i] < score[j]){
					rank[i]++;
				}else if ( score[i] > score[j]){
					rank[j]++;
				}
			}
		}

		System.out.printf("%10s %s %s\n", "이름", "점수", "석차" );
		for(int i=0; i<numOfPeople; i++){
			System.out.printf("%10s %4d %4d\n", name[i], score[i],rank[i]);
		}

	}

}
