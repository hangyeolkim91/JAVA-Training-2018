package com.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("¼ö½Ä[3+5]?");//12+30
		
		String str = br.readLine();
		str = str.replaceAll("\\s", "");
		
		//System.out.println(str);
		
		/*String[] operator = {"+", "-", "*", "/"}; 
		
		for( String oper : operator){
			
		}*/
		
		for( String op : new String[]{"+", "-", "*", "/"}){
			
			int pos = str.indexOf(op);
			if( pos > -1){
				int num1 = Integer.parseInt(str.substring(0,pos));
				int num2 = Integer.parseInt(str.substring(pos+1));
				
				int result = 0;
				
				switch(str.charAt(pos)){
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				}
				//System.out.printf("%d %c %d = %d", num1 , str.charAt(pos), num2 , result);
				String s = String.format("%d %c  %d = %d", num1 , str.charAt(pos), num2 , result);
				System.out.println(s);
			}
			
		}
	}

}
