package com.class4;

/*
 * StringBuffer   : 느림 , 동기화 지원
 * StringBuilder  : 빠름 , 동기화 미지원
 */

public class Test4 {

	public void stringTime(){
		System.out.println("stringTime...");
		
		long start = System.nanoTime();
		
		String str = "a";
		
		for(int i=0; i<50000; i++){
			str +="a";
		}
		
		long end = System.nanoTime();
		
		System.out.println("실행 시간 : " + (end - start));
//		System.out.println("start : " + start);
//		System.out.println("end : " + end);
	}
	
	public void stringBufferTime(){
		System.out.println("stringBufferTime...");
		
		long start = System.nanoTime();
		
		StringBuffer str = new StringBuffer("a");
		
		for(int i=0; i<50000; i++){
			str.append("a");
		}
		
		long end = System.nanoTime();
		
		System.out.println("실행 시간 : " + (end - start));
//		System.out.println("start : " + start);
//		System.out.println("end : " + end);
	}
	
	public void stringBuilderTime(){
		System.out.println("stringBuilderTime...");
		
		long start = System.nanoTime();
		
		StringBuilder str = new StringBuilder("a");
		
		for(int i=0; i<50000; i++){
			str.append("a");
		}
		
		long end = System.nanoTime();
		
		System.out.println("실행 시간 : " + (end - start));
//		System.out.println("start : " + start);
//		System.out.println("end : " + end);
	}
	
	public static void main(String[] args) {
		Test4 ob1 = new Test4();
		ob1.stringTime();
		ob1.stringBufferTime();
		ob1.stringBuilderTime();
	}

}
