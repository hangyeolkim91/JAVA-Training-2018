package com.rest;

import java.util.Scanner;

public class RestMain {

	public static void main(String[] args) {

		Rest r = new Rest();
		
		r.getXml();
		r.writeFile();
		Scanner sc = new Scanner(System.in);
		int ch;
		while(true){
			
			do{
				System.out.println("1.�ްԼҰ˻� 2.�̿��ڸ���Ʈ 3.â�ĸ���Ʈ 4.��Ÿ");
				ch = sc.nextInt();
			}while(ch <1 || ch>10);
			
			
			if(ch ==1 ){
				System.out.println("1.�� 2.�� 3.�� 4.�� 5.�� 6.�� 7.�� 8.�� 9.�� 10.�� 11.�� 12.�� 13.�� 14.��");
				ch = sc.nextInt();
				
				r.search(ch);
			}
		}
		//r.print();
	}

}
