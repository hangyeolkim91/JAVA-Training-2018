package com.dan;

import java.util.Scanner;

public class DanbiMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Danbi db = new DaniImpl();
		
		int ch;
		db.end();
		
		while(true){
			
			do{
				
				System.out.println("1.�Է� 2.���� 3.��� 4.����\n");
				ch = sc.nextInt();
			}while (ch<1||ch>5);
			
			switch(ch){
			
			case 1 :
				db.input();
				break;
			case 2 :
				db.save();
				break;
			case 3 :
				db.print();
				break;
			case 4 :
				db.end();
				break;
			}
		}
		
		
		
		
		
		

		
		
	}

}
