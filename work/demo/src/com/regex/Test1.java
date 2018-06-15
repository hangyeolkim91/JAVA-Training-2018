package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * java.util.regex
 * 정규 표현식
 * 
 * c[a-z]* : c로 시작하는 영단어 ( c, caa, cbvf)
 * c[a-z]  : c로 시작하는 단어 (두글자  ca,cg )
 * c[a-zA-Z0-9] : ca, cA, c5
 * c.  : ca, cB,c9, c&
 * c.* : c로 시작하는 모든 문자
 * c.*t : c로 시작하고 t로 끝나는 모든 문자
 * [b | c ].*  , [bc].*, [b-c].* : b 또는 c로 시작하는 모든 문자
 * [^b|c].* 또는 [^bc].* , [^b-c].* : b 또는 c로 시작하지 않는 문자
 * .*c.* : c가 포함된 모든 문자
 * 
 * [\\d]+ 또는 [0-9]+ : 하나 이상의 숫자
 *  
 */

public class Test1 {

	public static void main(String[] args) {
		
		String[] str = {"bat", "baby", "bonus" , "c", "cA", "ca", "c.","c0","car","combat","count","date","disc"};
		
		Pattern p;
		p = Pattern.compile("c[a-z]*");
		
		for(String s : str){
			Matcher m = p.matcher(s);
			
			if(m.matches()){
				System.out.println(s);
			}
		}
		System.out.println("-------------------------------");
		
		p =Pattern.compile("c[a-z]+");
		
		for( String s : str){
			Matcher m = p.matcher(s);
			
			if( m.matches()){
				System.out.println(s);
			}
		}
		
		System.out.println("-------------------------------");
		
		p =Pattern.compile("c.");
		
		for( String s : str){
			Matcher m = p.matcher(s);
			
			if( m.matches()){
				System.out.println(s);
			}
		}
		
		System.out.println("-------------------------------");
		
		String[] mail = {"aaa@aaa.com", "@aaa.co.kr",".@bbb.com","aaa@vvv.co.kr","sss.co.kr","abc@bbb"};
		
		// [\\w]+ : 한글자 이상의 영,숫자
		// @
		// (\\.[\\w]+) : 괄호 안에 있는 것은 반드시 한번은 사용
		// \\.: dot
		
		p =Pattern.compile("[\\w]+@[\\w]+(\\.[\\w]+)+");
		
		for( String s : mail){
			Matcher m = p.matcher(s);
			
			if( m.matches()){
				System.out.println(s);
			}
		}

	}

}
