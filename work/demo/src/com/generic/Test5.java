package com.generic;

import java.util.Scanner;


/*
 * 5-10자 이내의 문자열을 입력 받아 출력
 * 
 * 문자열?abcde  입력
 * abcde         출력
 * 
 * 
 * 조건
 * 1.5-10자 인지 확인
 * 2.영문자 ( 대소문자 구분 없이 )만 입력
 * 
 */

public class Test5 {
	
	public void inputForm(String str) throws Exception{
		
		if( str.length() <5 || str.length()>10){
			throw new Exception("문자열 길이는 5글자에서 10글자까지 입니다.");
		}
		
		for(int i=0; i<str.length(); i++){
			if( str.charAt(i) < 'a' || str.charAt(i) > 'z'){
				
				if( str.charAt(i) <'A' || str.charAt(i) > 'Z'){
					throw new Exception("영문자만 입력해주세요!");
					
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str;
		Test5 ob = new Test5();
		try {
			System.out.println("문자열?");
			str = sc.next();
			ob.inputForm(str);
			
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}

}
