package com.apitest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {

		String[] str = {"�����ްԼ�","����", "������","��"};
		
		Pattern p = Pattern.compile("[��-��]+.*");
		for(int i=0; i<str.length; i++){
			Matcher m = p.matcher(str[i]);
			if(m.matches()){
				System.out.println(str[i]);
			}
		}
		
		
		
		
	}

}
