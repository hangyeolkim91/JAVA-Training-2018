package com.score3;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		
		
		ScoreImpl sim = new ScoreImpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("1.입력 \n2.출력 \n3.학번검색 \n4.이름검색 \n5.총점내림정렬\n6.학번오름정렬 \n7.종료 \n:");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			case 1:
				sim.input();
				break;
			case 2:
				sim.print();
				break;
			case 3:
				sim.searchSid();
				break;
			case 4:
				sim.searchName();
				break;
			case 5:
				sim.descSortTotal();
				break;
			case 6:
				sim.ascSortSid();
				
				break;
			default:
				System.out.println("종료합니다..");
				System.exit(0);
			}
			
		}
		

	}

}
