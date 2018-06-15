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

		String str = "우리나라 대한민국 대한독립 대한의 건아..";
		String oldStr = "대한";
		String newStr = "大韓";
		
		System.out.println(Test2.replaceAll(str, oldStr, newStr));
	}

}
