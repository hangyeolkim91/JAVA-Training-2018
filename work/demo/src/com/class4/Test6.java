package com.class4;


// String은 불변하다(immutable)

public class Test6 {

	public static void main(String[] args) {

		String s1 = "서울,부산,대구";
		String[] ss = s1.split(",");
		
		for(String s : ss ){
			System.out.println(s);
		}
		
		String s2 = "seoul";
		String s3 = "SEOUL";
		
		System.out.println(s2.equals(s3));
		System.out.println(s2.equalsIgnoreCase(s3));
		
		String s4 = "abc.def.hij";
		System.out.println(s4.indexOf("."));
		System.out.println(s4.lastIndexOf("."));
		System.out.println(s4.indexOf("def"));
		System.out.println(s4.indexOf("x"));
		
		String s5 = "우리나라 대한민국 좋은나라 대한민국";
		String s6 = s5.replaceAll("대한", "大韓");
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim());
		System.out.println(s7.replaceAll(" ", ""));
		System.out.println(s7.replaceAll("\\s", ""));
		
		char ch = "abcdefg".charAt(2);
		
		System.out.println(ch);
		
		System.out.println("abcdefg".startsWith("habc"));
		System.out.println("abcdefg".startsWith("abc"));
		
		System.out.println("abcdefg".length());
		
		String s8 = "abcdefg"; // 101 
		String s9 = "abcddfg"; // 100
		
		//unicode 기준으로 사전식 배열 할때
		System.out.println(s8.compareTo(s9));
		System.out.println(s9.compareTo(s8));
		
	}

}
