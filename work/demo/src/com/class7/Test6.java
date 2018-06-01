package com.class7;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {

	private static final String city[] = {"서울","부산","대구","인천","광주","대전","울산"};
	
	public static void main(String[] args) {

		Vector<String> v = new Vector<String>();
		
		for( String c : city){
			v.add(c);
		}
		String str = v.firstElement();
		
		System.out.println("첫번째 " + str);
		
		str = v.lastElement();
		
		System.out.println("마지막 " + str);
		
		str =v.get(1);
		
		System.out.println("두번째 : " + str);
		
		for(int i=0; i<v.size(); i++){
			System.out.print(v.get(i) + " ");
		}
		System.out.println();
		for(String s : v){
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		for(Iterator<String> i = v.iterator(); i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		Iterator<String> it = v.iterator();
		while( it.hasNext()){
			String s = it.next();
			System.out.print(s+ " " );
		}
		System.out.println();
		
	}

}
