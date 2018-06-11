package com.stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		int data;
		
		System.out.print("문자열 입력 : ");
		
		Reader rd = new InputStreamReader(System.in);
		
		Writer wr = new OutputStreamWriter(System.out);
		
		while((data = rd.read()) != -1){
			
			wr.write(data);
			wr.flush();
		}

	}

}
