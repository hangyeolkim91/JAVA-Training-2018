package com.stream;

import java.io.File;
import java.io.FileOutputStream;

public class Test12 {

	public static void main(String[] args) {

		String str = "d:/doc/temp/java/test.txt";
		
		String path = str.substring(0,str.lastIndexOf("/"));
		System.out.println(path);
		
		File f = new File(path);
		
		if( !f.exists()){
			f.mkdirs();
		}
		
		/*if( !f.getParentFile().exists()){
			f.getParentFile().mkdirs();
		}*/
		
		try {
			FileOutputStream fos = new FileOutputStream(str);
			System.out.println("문자열 입력");
			int data;
			
			while((data =System.in.read()) != -1){
				fos.write(data);
				fos.flush();
			}
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
