package com.class3;

import java.io.IOException;
import java.util.Scanner;

class Calc{
	
	private int num1, num2;
	private char operator;
	
	public boolean input() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 정수?");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.print("연산자 ?[+,-,*, /]");
		
		operator = (char) System.in.read();
		
		if(operator != '+' && operator != '-' && operator != '*' && operator != '/'){
			return false;
		}
		return true;
	}
	public int result(){
		int r=0;
		switch(operator){
		case '+':
			r = num1+num2;
			break;
		case '-':
			r = num1 - num2;
			break;
		case '*':
			r = num1 * num2;
			break;
		case '/':
			r = num1 / num2;
			break;
		}
		return r;
	}
	
	public void print(int r){
		System.out.printf("%d %c %d = %d", num1, operator, num2, r);
	}
}

public class Test6 {

	public static void main(String[] args) throws IOException {
		
		Calc ob = new Calc();
		//boolean check = ob.input();
		
		if( !ob.input() ){
			return;
		}
		int r = ob.result();
		ob.print(r);
		
		
		
	}

}
