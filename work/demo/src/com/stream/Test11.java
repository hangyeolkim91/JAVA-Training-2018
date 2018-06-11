package com.stream;

import java.io.File;
import java.io.IOException;
import java.sql.Date;


//File 클래스
/*
 * 파일 및 폴더를 관리할 수 있도록 기능을 제공해 주는 클래스
 * 파일의 복사 또는 이름변경등의 조작을 할 경우에 사용될뿐
 * 파일의 내용을 입출력하기위한 메소드는 제공하지 않는다.
 * 
 */

public class Test11 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("d:/doc/test.txt");
		
		System.out.println("파일 정보 ....");

		System.out.println("file name : " + f.getName());
		System.out.println("file length : " + f.length());
		System.out.println("file path : " + f.getAbsolutePath());
		System.out.println("file canonical path : " + f.getCanonicalPath());
		System.out.println("file created : " + new Date(f.lastModified()));
		System.out.println("file parent path :" + f.getParent());
		System.out.println("file read :" + f.canRead());
		System.out.println("file write : " + f.canWrite());
		System.out.println("file excute : "+f.canExecute());
		
		String path = System.getProperty("user.dir");
		System.out.println("current path : " + path);
		
		
		
	}

}
