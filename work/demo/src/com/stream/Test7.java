package com.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {

		//원본파일? d:\\doc\\test.txt
		//대상파일? d:\\doc\\out2.txt
		//복사 완료
		
		Scanner sc = new Scanner(System.in);
		String path1, path2;
		
		try {
			System.out.println("원본파일?");
			path1 = sc.next();
			
			System.out.println("대상파일?");
			path2 = sc.next();
			
			FileInputStream fis = new FileInputStream(path1);
			FileOutputStream fos = new FileOutputStream(path2);
			
			int data;
			while((data = fis.read()) != -1){
				fos.write(data);
			}
			fos.flush();
			fis.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
