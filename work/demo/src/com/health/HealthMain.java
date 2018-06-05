package com.health;

import java.util.Scanner;


public class HealthMain {

	public static void main(String[] args) {

		Health health = new HealthImpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("\n1.회원가입 \n2.회원목록 \n3.회원삭제 \n4.회원수정 \n5.회원번호검색\n6.회원이름검색 \n7.종료 \n:");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			case 1:
				health.register();;

				break;
			case 2:
				health.showMembers();
				break;
			case 3:
				health.delete();
				health.showMembers();
				break;
			case 4:
				health.update();
				health.showMembers();
				break;
			case 5:
				health.searchByMemberId();
				break;
			case 6:
				health.searchByMemberName();
				break;
			default:
				System.out.println("종료합니다..");
				System.exit(0);
			}
			
		}
	}

}
