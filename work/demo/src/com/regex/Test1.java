package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * java.util.regex
 * ���� ǥ����
 * 
 * c[a-z]* : c�� �����ϴ� ���ܾ� ( c, caa, cbvf)
 * c[a-z]  : c�� �����ϴ� �ܾ� (�α���  ca,cg )
 * c[a-zA-Z0-9] : ca, cA, c5
 * c.  : ca, cB,c9, c&
 * c.* : c�� �����ϴ� ��� ����
 * c.*t : c�� �����ϰ� t�� ������ ��� ����
 * [b | c ].*  , [bc].*, [b-c].* : b �Ǵ� c�� �����ϴ� ��� ����
 * [^b|c].* �Ǵ� [^bc].* , [^b-c].* : b �Ǵ� c�� �������� �ʴ� ����
 * .*c.* : c�� ���Ե� ��� ����
 * 
 * [\\d]+ �Ǵ� [0-9]+ : �ϳ� �̻��� ����
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
		
		// [\\w]+ : �ѱ��� �̻��� ��,����
		// @
		// (\\.[\\w]+) : ��ȣ �ȿ� �ִ� ���� �ݵ�� �ѹ��� ���
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
