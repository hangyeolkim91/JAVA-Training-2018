package com.stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * InputStreamReader(bridge stream)
 * 
 * 1byte�� Stream�� 2byte Stream���� ��ȯ��Ų��.
 * 
 * 
 */

public class Test3 {

	public static void main(String[] args) throws IOException {

		int data;
		System.out.print("���ڿ� �Է�: ");
		
		Reader rd = new InputStreamReader(System.in);
		
		
		
		while( (data = rd.read()) != -1){
			char ch = (char)data;
			System.out.print(ch);
		}
		
		
		
		
	}

}
