package com.stream1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*
 * FileWriter
 * FileWriter 클래스는 출력할 유니코드 문자열을 시스템에 맞는
 * 디폴트 문자 인코딩의 바이트로 변환하여 파일에 저장한다.
 * 
 * BufferedWriter
 * 필터 스트림으로 다른 출력 스트림을 생성자의 인자로 받아
 * 생성하며 문자를 버퍼링 하는 것에 따라 문자, 배열, 또는 스트링을 
 * 문자형태로 출력한다.
 * 
 * 문자, 바이트스트림을 버퍼에 출력한다.
 */

public class Test3 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			FileWriter fw = new FileWriter("d:/doc/out7.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("문자열 입력");
			String str;
			while((str = br.readLine())!=null){
				
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			bw.flush();
			bw.close();
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
