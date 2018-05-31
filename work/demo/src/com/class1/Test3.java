package com.class1;

import java.util.Scanner;


class Sum{
	
	int n,sum;
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수입력?");
		n = sc.nextInt();
		
		
	}
	
	public int sum(){
		
		for(int i=1; i<=n; i++){
			sum+=i;
		}
		return sum;
	}
	
	public void print(int s){
		System.out.println("합계 : " + s);
	}
	
}

public class Test3 {

	public static void main(String[] args) {

		Sum ob = new Sum();
		
		ob.input();
		int r = ob.sum();
		
		ob.print(r);
		
	}

}
