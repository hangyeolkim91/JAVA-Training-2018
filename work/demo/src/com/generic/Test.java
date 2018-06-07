package com.generic;

import java.util.Scanner;

/*
 * ����ó��
 * Exception
 */

public class Test {

	public static void main(String[] args) {

		int num1, num2, result=0;
		
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("�� ���� ��?");
			
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.println("������?");
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
			System.out.println("������ �Է��Ͻÿ�.");
			
		}catch(ArithmeticException e){
			System.out.println("0���� ���� �� ����.");
			
		}catch (Exception e) {

			/*System.out.println(e);
			e.printStackTrace();*/
			
			System.out.println("�Է��� Ʋ��");
			
		}finally{
			System.out.println("�׻� �����");
		}
	}

}
