package com.stream1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/*
 * FileReader
 * 
 * 파일에서 바이트를 읽어 문자,바이트스트림으로 변환
 * 
 */

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {

		FileReader fr = new FileReader("d:/doc/test.txt");
		BufferedReader br = new BufferedReader(fr);
		
		try {
			
			String str;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
