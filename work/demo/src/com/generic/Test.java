package com.generic;

import java.util.Scanner;

/*
 * 예외처리
 * Exception
 */

public class Test {

	public static void main(String[] args) {

		int num1, num2, result=0;
		
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("두 개의 수?");
			
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.println("연산자?");
			oper = sc.next();
		
			if(oper.equals("+")){
				result = num1 + num2;
			}else if ( oper.equals("-")){
				result = num1-num2;
			}else if ( oper.equals("/")){
				result = num1/num2;
			
			}else if ( oper.equals("*")){
				result = num1*num2;
			}
			
			System.out.printf("%d %s %d = %d ",num1,oper,num2,result);
			
		} catch(NumberFormatException e){
			System.out.println("정수를 입력하시오.");
			
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없다.");
			
		}catch (Exception e) {

			/*System.out.println(e);
			e.printStackTrace();*/
			
			System.out.println("입력이 틀림");
			
		}finally{
			System.out.println("항상 실행됨");
		}
	}

}
