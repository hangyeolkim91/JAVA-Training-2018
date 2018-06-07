package com.excep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperatorMain {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		double num1, num2, result=0;
		
		OperationAuthen auth = new OperationAuthen();
		
		
		try {
			System.out.println("두 수를 입력[a,b]?");
			str = br.readLine();
			auth.inputForm(str);
			
			String[] temp = str.split(",");
			
			auth.number(temp[0]);
			num1 = Double.parseDouble(temp[0]);
			
			auth.number(temp[1]);
			num2 = Double.parseDouble(temp[1]);
			
			System.out.println("연산자 입력?");
			
			char ch = (char) System.in.read();
			
			auth.operator(ch);
			
			if( ch == '+'){
				result = num1 + num2;
			}else if ( ch == '-'){
				result = num1-num2;
			}else if ( ch == '/'){
				result = num1/num2;
			
			}else if ( ch == '*'){
				result = num1*num2;
			}
			
			System.out.printf("%g %c %g = %g ",num1,ch,num2,result);
			
			
		} catch (IOException e) {

			System.out.println(e.toString());
		} catch(MyException e){
			System.out.println(e.toString());
		}

	}

}
