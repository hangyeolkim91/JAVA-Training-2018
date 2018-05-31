package com.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestA{
	public void print(String r){
		System.out.println(r);
	}
}

class Calc extends TestA{
	
	private String str;
	private String operator;
	private String[] num;
		
	public String input() throws IOException{
		
		int result = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("두 수 [5,2]?");
		str = br.readLine();
		System.out.println( "[+,-,*,/] ?");
		operator = br.readLine();
		
		
		str = str.replaceAll("\\s", "");
		num = str.split(",");
		int num1 = Integer.parseInt(num[0]);
		int num2 = Integer.parseInt(num[1]);
		
		switch(operator){
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*" : 
			result = num1 * num2;
			break;
		case "/" : 
			result = num1 / num2;
			break;
		}
		
		String res= String.format("%d %s %d = %d", num1, operator, num2 , result);
		return res;
		//super.print(res);
		
	}
	
}

public class Test9 {

	public static void main(String[] args) throws IOException {
		
		// 두수 [5,2]? 10, 25
		// 연산자 [+,-,*,/] ?
		// 10 + 25 = 35
		Calc ca = new Calc();
		String result = ca.input();
		ca.print(result);
	}

}
