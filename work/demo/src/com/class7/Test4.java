package com.class7;

/*
 * ���� Ŭ����
 * Annonymous, �͸�, ���� Ŭ���� 
 */

public class Test4 {

	public Object getTitle(){
		
		return new Object(){ //�ַ� �������̽��� ����
			
			@Override
			public String toString() {
				return "�͸��� Ŭ����";
			}
		};
	}
	public static void main(String[] args) {

		Test4 t = new Test4();
		int a = 10;
		System.out.println( t.getTitle());
		
	}

}
