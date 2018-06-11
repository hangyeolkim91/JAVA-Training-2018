package com.stream;

import java.io.FileInputStream;

/*
 * 파일 입출력
 */

public class Test5 {
	
	public  static void main(String[] args){
		
		try {
			FileInputStream fis = new FileInputStream("d:\\doc\\test2.txt");
			int data;
			while((data = fis.read()) != -1){
				
				//char ch = (char)data;
				
				System.out.write(data);
				System.out.flush();
			}
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
