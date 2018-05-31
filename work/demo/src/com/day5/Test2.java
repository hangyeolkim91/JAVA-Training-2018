package com.day5;

import java.util.Scanner;


public class Test2 {

	public static void main(String[] args) {

		//10명 이내의 이름과 점수를 입력 받아 
		// 점수가 높은 사람에서 낮은 사람으로 출력 내림차순
		
		Scanner sc = new Scanner(System.in);
		
		String[] name;
		int[] score;
		
		int temp1;
		String temp2;
		int numOfPeople;
		
		do{
			System.out.print("몇 명[1-10]?");
			numOfPeople = sc.nextInt();
		}while(numOfPeople <1 || numOfPeople > 10);
		
		// 배열의 메모리 할당 ( 객체 생성 )
		name = new String[numOfPeople];
		score = new int[numOfPeople];
		
		
		//System.out.print(numOfPeople+" 명의 이름과 점수?");
		for(int i=0; i<numOfPeople; i++){
			System.out.print((i+1) + "번째 이름?");
			name[i] = sc.next();
			
			System.out.print("점수?");
			score[i] = sc.nextInt();
		}
		
		/*System.out.print("Source Data : ");
		
		for(int i=0; i<score.length; i++){
			System.out.printf("%4s : %4d", name[i],score[i]);
		}
		System.out.println();*/
		
		// Selection Sort
		for(int i=0; i<score.length; i++){
			for(int j=i+1; j<score.length; j++){
				if(score[i] < score[j]){
					temp1 = score[j];
					score[j]= score[i];
					score[i] = temp1;
					
					temp2 = name[j];
					name[j] = name[i];
					name[i] = temp2;
					
				}
			}
		}
		
		
		
		for(int i=0; i<numOfPeople; i++){
			System.out.printf("%10s %4d\n", name[i],score[i]);
		}
		
	}

}
