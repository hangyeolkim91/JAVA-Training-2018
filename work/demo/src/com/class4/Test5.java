package com.class4;

public class Test5 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		
		sb.append("서울");
		sb.append("부산");
		sb.append("대구");
		
		System.out.println(sb);
		
		//StringBuffer -> String으로 변환
		
		String str = sb.toString();
		System.out.println(str);
		
		//Integer
		int a = 24;
		System.out.println(a);
		System.out.println(Integer.toString(a));   // 문자
		System.out.println(Integer.toString(a,2)); // 이진수
		System.out.println(Integer.toString(a,16));// 16 진수
		
	}

}
