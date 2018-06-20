package com.apitest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		
		
		String s = "abcde";
		
		System.out.println(s.charAt(s.length()/2));
		try {
			FileInputStream fis = new FileInputStream("C:/Users/itwill/Downloads/ASCII-images.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String str;
			while( (str = br.readLine())!=null){
				System.out.println(str);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
