package com.score4;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		Score s = new ScoreImpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("\n1.�Է� \n2.��� \n3.���� \n4.���� \n5.�й��˻�\n6.�̸��˻� \n7.���� \n:");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			case 1:
				s.input();
				System.out.println("�Է¼���!");
				break;
			case 2:
				s.print();
				break;
			case 3:
				s.delete();
				System.out.println("��������!");
				s.print();
				break;
			case 4:
				s.update();
				s.print();
				break;
			case 5:
				s.findSid();
				break;
			case 6:
				s.findName();
				break;
			default:
				System.out.println("�����մϴ�..");
				System.exit(0);
			}
			
		}
		
	}

}
