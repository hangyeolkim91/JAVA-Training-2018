package com.stream;

import java.io.File;
import java.io.IOException;
import java.sql.Date;


//File Ŭ����
/*
 * ���� �� ������ ������ �� �ֵ��� ����� ������ �ִ� Ŭ����
 * ������ ���� �Ǵ� �̸�������� ������ �� ��쿡 ���ɻ�
 * ������ ������ ������ϱ����� �޼ҵ�� �������� �ʴ´�.
 * 
 */

public class Test11 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("d:/doc/test.txt");
		
		System.out.println("���� ���� ....");

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
