package com.health;

import java.util.Scanner;


public class HealthMain {

	public static void main(String[] args) {

		Health health = new HealthImpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("\n1.ȸ������ \n2.ȸ����� \n3.ȸ������ \n4.ȸ������ \n5.ȸ����ȣ�˻�\n6.ȸ���̸��˻� \n7.���� \n:");
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
				System.out.println("�����մϴ�..");
				System.exit(0);
			}
			
		}
	}

}
