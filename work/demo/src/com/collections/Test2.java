package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * List(I) - ArrayList(C)
 * Vector보다 성능이 좋다 ( 동기화가 안됨 )
 * 
 */

public class Test2 {

	public static void main(String[] args) {

		ArrayList<String> lists = new ArrayList<String>();
		lists.add("서울");
		lists.add("부산");
		lists.add("대구");
		
		Iterator<String> it = lists.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.print(str+ " ");
		}
		System.out.println();
		
		ListIterator<String> lit = lists.listIterator();
		
		while(lit.hasNext()){
			System.out.print(lit.next()+ " ");
		}
		System.out.println();
		
		while(lit.hasPrevious()){
			System.out.print(lit.previous()+ " ");
		}
		System.out.println();
		
		
		List<String> list1 = new ArrayList<String>();
		
		list1.addAll(lists);
		
		list1.add("인천");
		
		int n = list1.indexOf("부산");
		list1.add(n+1,"광주");
		
		for(String c : list1){
			System.out.print(c);
		}
		System.out.println();
		list1.add("자바프로그래머");
		list1.add("프레임워크");
		list1.add("스트럿츠");
		list1.add("자바란?");
		list1.add("스프링");
		
		String str ;
		
		for( Iterator<String> it2 = list1.iterator(); it2.hasNext();){
			str = it2.next();
			if(str.startsWith("자바")){
				System.out.println(str);
			}
		}
	}

}
