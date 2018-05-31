package com.day1;

class Test1 {// 클래스 

	// 클래스의 이름은 반드시 첫 글자 영문 대문자
	// 저장하는 파일의 이름은 클래스의 이름과 같다.

	public static void main(String[] args) { // Method
	// public : 접근지정자 (private, protected)
	// void   : 반환값(int, double...)
	// main   : 메소드 이름 (영문 소문자) (main은 반드시 존재해야하는 메소드)
	// ()     : 매개변수

		System.out.print("자바 첫시간!!!!\n\n");
		System.out.println("두번째 프로그램\n");
		System.out.println();
	}
	// java Test1.class -> error 발생
	// java Test1 -> O
}
