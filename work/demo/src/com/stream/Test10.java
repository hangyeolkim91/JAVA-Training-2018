package com.stream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test10 {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos;
			PrintStream ps;
			
			fos = new FileOutputStream("d:/doc/out5.txt");
			ps = new PrintStream(fos);
			
			ps.println("배수지");
			ps.println("한지혜");
			ps.println("abcf");
			ps.println("abcaewf");
			
			ps.close();
			fos.close();
			
			// true == append
			fos = new FileOutputStream("d:/doc/out5.txt",true);
			ps = new PrintStream(fos);
			
			ps.println("a");
			ps.println("b");
			ps.println("c");
			ps.println("D");
			
			ps.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
