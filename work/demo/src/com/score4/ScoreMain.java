package com.score4;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		Score s = new ScoreImpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("\n1.입력 \n2.출력 \n3.삭제 \n4.수정 \n5.학번검색\n6.이름검색 \n7.종료 \n:");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			case 1:
				s.input();
				System.out.println("입력성공!");
				break;
			case 2:
				s.print();
				break;
			case 3:
				s.delete();
				System.out.println("삭제성공!");
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
				System.out.println("종료합니다..");
				System.exit(0);
			}
			
		}
		
	}

}
