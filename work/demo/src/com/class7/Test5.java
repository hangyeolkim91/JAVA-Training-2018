package com.class7;

import java.util.List;
import java.util.Vector;

/*
 * Collection Framework(방법)
 * 
 * List(I) ArrayList, Vector
 * Map(I)  Hashtable, Hashmap
 * 
 */


public class Test5 {

	
	
	public static void main(String[] args) {

		// 기본 데이터 타입은 Object 이다.
		
		Vector v = new Vector();
		//List<String> vector = new Vector<String>();
		v.add("서울");
		v.add(30);
		v.add('a');
		String str = (String) v.get(0);
		
		System.out.println(str);
		
		int a = (int) v.get(1);
		
		char c = (char) v.get(2);
		
		System.out.println(a + " " + c);
		System.out.println(v);
	}

}
