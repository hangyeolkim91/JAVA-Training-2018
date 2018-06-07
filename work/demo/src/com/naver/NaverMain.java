package com.naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Naver naver = new NaverImpl();
		
		int ch;
		
		while(true){
			
			do{
				System.out.print("\n1.ȸ������ \n2.��üȸ����� \n3.ȸ��Ż�� \n4.���̵�˻� \n5.�̸��˻�\n6.���� \n:");
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
				System.out.println("������ ���̵�?");
				String did = sc.next();
				naver.delete(did);
				break;
			case 4:
				System.out.println("�˻��� ���̵�?");
				String id = sc.next();
				naver.searchById(id);
				
				break;
			case 5:
				System.out.println("�˻��� �̸�?");
				String name = sc.next();
				naver.searchByName(name);
				break;
			case 6:
				
			default:
				System.out.println("�����մϴ�..");
				System.exit(0);
			}
			
		}
	}

}
