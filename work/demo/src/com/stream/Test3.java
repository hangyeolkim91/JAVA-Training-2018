package com.stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * InputStreamReader(bridge stream)
 * 
 * 1byte의 Stream을 2byte Stream으로 변환시킨다.
 * 
 * 
 */

public class Test3 {

	public static void main(String[] args) throws IOException {

		int data;
		System.out.print("문자열 입력: ");
		
		Reader rd = new InputStreamReader(System.in);
		
		
		
		while( (data = rd.read()) != -1){
			char ch = (char)data;
			System.out.print(ch);
		}
		
		
		
		
	}

}
