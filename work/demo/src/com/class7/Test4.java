package com.class7;

/*
 * 내부 클래스
 * Annonymous, 익명, 무명 클래스 
 */

public class Test4 {

	public Object getTitle(){
		
		return new Object(){ //주로 인터페이스가 쓰임
			
			@Override
			public String toString() {
				return "익명의 클래스";
			}
		};
	}
	public static void main(String[] args) {

		Test4 t = new Test4();
		int a = 10;
		System.out.println( t.getTitle());
		
	}

}
