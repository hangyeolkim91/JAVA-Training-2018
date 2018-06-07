package com.naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Naver naver = new NaverImpl();
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("\n1.회원가입 \n2.전체회원출력 \n3.회원탈퇴 \n4.아이디검색 \n5.이름검색\n6.종료 \n:");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			case 1:
				
				naver.input();
				break;
			case 2:
				naver.print();
				break;
			case 3:
				System.out.println("삭제할 아이디?");
				String did = sc.next();
				naver.delete(did);
				break;
			case 4:
				System.out.println("검색할 아이디?");
				String id = sc.next();
				naver.searchById(id);
				
				break;
			case 5:
				System.out.println("검색할 이름?");
				String name = sc.next();
				naver.searchByName(name);
				break;
			case 6:
				
			default:
				System.out.println("종료합니다..");
				System.exit(0);
			}
			
		}
	}

}
