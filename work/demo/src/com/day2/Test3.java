package com.day2;

import java.io.IOException;

class Test3 {

	public static void main(String[] args) throws IOException {

		char ch ,result;

		System.out.print( "한문자?");

		int a = System.in.read(); // 반환값이 int

		ch = (char) a ;//System.in.read();

		//System.out.println(ch);   // 문자 출력
		//System.out.println(ch+1); // ascii code 값

		char b = (char) ( a+1);  // a값의 다음 문자
	
		//System.out.println(b);

		result = ch >= 65 && ch <=92 ? (char)(ch+32) : ( ch>='a' && ch<='z' ? (char)(ch - 32) : ch);

		System.out.println(ch+":"+result);
		
		System.out.println(ch);
		System.out.println(Integer.toString(ch));
	}
}
