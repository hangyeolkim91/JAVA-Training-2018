package com.rest;

import java.util.Scanner;

public class RestMain {

	public static void main(String[] args) {

		Rest r = new Rest();
		
		r.getXml();
		r.specialInit();
		r.eyoung();
		//r.print();
		
		Scanner sc = new Scanner(System.in);
		
		int ch;
		while(true){
			
			do{
				System.out.println("1.�ްԼҰ˻� 2.�̿��ڸ���Ʈ 3.â�ĸ���Ʈ 4.�̻��ްԼ� 5.����");
				ch = sc.nextInt();
			}while(ch <1 || ch>10);
			
			
			if(ch ==1 ){
				System.out.println("1.�� 2.�� 3.�� 4.�� 5.�� 6.�� 7.�� 8.�� 9.�� 10.�� 11.�� 12.�� 13.�� 14.��");
				ch = sc.nextInt();
				
				r.search(ch);
			}else if ( ch ==2 ){
				r.eyounprint();
			}else if ( ch == 3){
				r.printChang();
			}else if ( ch==4){
				r.printSpecial();
				
			}else if ( ch == 5){
				r.writeFile();
				System.exit(0);
			}
		}
		
	}

}
