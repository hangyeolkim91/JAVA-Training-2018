package com.stream1;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
 * StringReader
 * StringWriter
 */

public class Test6 {

	public static void main(String[] args) {

		int ch;
		String str = "Hello";
		StringReader sr = new StringReader(str);
		StringWriter sw = new StringWriter();
		
		try {
			while( (ch=sr.read()) != -1){
				sw.write(ch);
			}
			
			System.out.println(sw.toString());
			
			StringBuffer sb = sw.getBuffer();
			System.out.println(sb.toString());
			
			sw.close();
			sr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
