package com.score3;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		
		
		ScoreImpl sim = new ScoreImpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("1.�Է� \n2.��� \n3.�й��˻� \n4.�̸��˻� \n5.������������\n6.�й��������� \n7.���� \n:");
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
				System.out.println("�����մϴ�..");
				System.exit(0);
			}
			
		}
		

	}

}
