package com.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {
	
	public boolean fileCopy(String src, String dest){
		
		File srcFile = new File(src);
		File destFile = new File(dest);
		
		if(!srcFile.exists()){
			return false;
		}
		
		try {
			FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(destFile);
			
			int data;
			
			byte[] buffer = new byte[1024];
			
			while( fis.read(buffer) != -1){
				fos.write(buffer);
			}
			fos.flush();
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Test8 ob = new Test8();
		Scanner sc = new Scanner(System.in);
		
		/*String srcPath, destPath;
		
		System.out.println("원본파일?");
		srcPath = sc.next();
		
		System.out.println("대상파일?");
		destPath = sc.next();
		
		ob.fileCopy(srcPath, destPath);*/

		if(ob.fileCopy("d:/doc/test.txt", "d:/doc/out3.txt")){
			System.out.println("파일 복사 완료!");
		}else{
			System.out.println("파일 복사 실패");
		}
	}

}
