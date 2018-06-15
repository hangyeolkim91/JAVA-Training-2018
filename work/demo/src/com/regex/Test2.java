package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Test2 {

	public static String replaceAll(String str, String oldStr, String newStr){
		
		if(str == null)
			return null;
		
		Pattern p = Pattern.compile(oldStr);
		
		Matcher m = p.matcher(str);
		
		StringBuffer sb = new StringBuffer();
		
		while(m.find()){
			
			m.appendReplacement(sb, newStr);
			
		}
		
		m.appendTail(sb);
		
		return sb.toString();
		
	}
	public static void main(String[] args) {

		String str = "�츮���� ���ѹα� ���ѵ��� ������ �Ǿ�..";
		String oldStr = "����";
		String newStr = "����";
		
		System.out.println(Test2.replaceAll(str, oldStr, newStr));
	}

}
