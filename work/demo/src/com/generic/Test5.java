package com.generic;

import java.util.Scanner;


/*
 * 5-10�� �̳��� ���ڿ��� �Է� �޾� ���
 * 
 * ���ڿ�?abcde  �Է�
 * abcde         ���
 * 
 * 
 * ����
 * 1.5-10�� ���� Ȯ��
 * 2.������ ( ��ҹ��� ���� ���� )�� �Է�
 * 
 */

public class Test5 {
	
	public void inputForm(String str) throws Exception{
		
		if( str.length() <5 || str.length()>10){
			throw new Exception("���ڿ� ���̴� 5���ڿ��� 10���ڱ��� �Դϴ�.");
		}
		
		for(int i=0; i<str.length(); i++){
			if( str.charAt(i) < 'a' || str.charAt(i) > 'z'){
				
				if( str.charAt(i) <'A' || str.charAt(i) > 'Z'){
					throw new Exception("�����ڸ� �Է����ּ���!");
					
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str;
		Test5 ob = new Test5();
		try {
			System.out.println("���ڿ�?");
			str = sc.next();
			ob.inputForm(str);
			
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}

}
