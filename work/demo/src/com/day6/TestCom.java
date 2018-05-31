package com.day6;

import java.util.Scanner;

public class TestCom {

	public int w,h; //전역변수 ,  instance변수
	
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로?");
		w = sc.nextInt();
		
		System.out.print("세로?");
		h = sc.nextInt();
		
		
		
		//sc.close();
		
		//return;
	}
	
	public int area(){
		
		int result;
		
		result = w * h;
		
		return result;
	}
	
	public int length(){
		
		
		return 2*(w + h );
	}
	
	public void print(int b, int c){
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		
		System.out.println("넓이 : " + b);
		System.out.println("둘레 : " + c);
	}
	
}
