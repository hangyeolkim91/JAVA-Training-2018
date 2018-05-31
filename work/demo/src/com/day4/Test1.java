package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, result=0;
		
		char oper;
		
		System.out.print("첫번째 수?");
		num1 = sc.nextInt();
		
		System.out.print("두번째 수?");
		num2 = sc.nextInt();
		
		System.out.print("연산자?[+,-,*,/]");
		oper = (char) System.in.read();
		
		switch(oper){
		
		case '+':
			result = num1+num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			try{
			result = num1 /num2;
			}catch(Exception e){
				System.out.println("0으로는 나눌 수 없습니다." + e.toString());
			}
			break;
		default:
			result = 0;
		}
		System.out.printf("%d %c %d = %d\n", num1, oper, num2,result);
		//System.out.println("결과 : " + result);
		

	}

}



/* 
 * [자료형]
 * 
 * boolean : true / false
 * 
 * 
 * 정수형
 * byte    : -128 ~ 127
 * short   : -32768 ~ 32767
 * int     : 4byte
 * long    : 8byte
 * 
 * 진수
 *  10진수 : 10 , 8진수 : 016 , 16진수 : 0x17
 *  
 *  실수
 *  
 *  float : 4byte
 *  double: 8byte
 *  단정도실수(float): 3.14f
 *  배정도실수(double) : 3.14
 *  
 *  문자
 *  
 *  char : 2byte(utf-16) \u0000 'a'
 *  
 *  [연산자]
 *  +, *, - , / , %, ++, --, 
 *  
 *  [관계 연산자]
 *  > , < , >=, <= : 결과 -> true/false
 *  
 *  [등가 연산자]
 *  ==, !=
 *  
 *  [논리 연산자]
 *  &&(and), ||(or), !(not), ^(xor)
 *  
 *  [비트 연산자]
 *  &, |, ~, >>, <<, >>>
 *  
 *  [삼항 연산자]
 *  
 *  조건 ? 참 : 거짓
 *  
 *  [대입 연산자]
 *  =, +=, -=, *=, /= , %=
 *  
 *  ---------------------------------
 *  
 *  int a = 10;
 *  float b;
 *  
 *  b = a;         // 암시적 형변환
 *  b = (float) a; //명시적 형변환
 *  
 *  a = b;       (x)
 *  a = (int) b; (o) //명시적 형변환
 *  
 *  -----------------------------------
 *  
 *  [제어문]
 *  
 *  if( 조건 ) {
 *  	작업;
 *  }
 *  
 *  if( 조건 ) {
 *  	
 *  }else{
 *  
 *  }
 *  
 *  if ( ) {
 *  }else if (){
 *  }else{
 *  }
 *  
 *  [반복문]
 *  
 *  while(){
 *  }
 *  
 *  do{
 *  }while();
 *  
 *  while( true ){
 *  }
 *  
 *  
 *  
 *  
 */
