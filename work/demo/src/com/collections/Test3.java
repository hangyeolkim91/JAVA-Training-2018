package com.collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/*
 * collection
 * Map <키, 값>
 * HashTable : 동기화 지원 
 * HashMap
 * 
 * 키는 중복적인 값을 가질 수 없다 ( 키는 set )
 * 키의 값이 중복되면 마지막 값이 저장된다(수정)
 */

public class Test3 {

	public static final String[] name ={"배수지", "천송이", "전지현", "송지효", "박신혜"};
	public static final String[] tel = {"111-111", "222-222","333-333","111-111","444-444"};
	
	public static void main(String[] args) {
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		for(int i=0; i<name.length; i++){
			ht.put(tel[i],name[i]);
		}
		
		System.out.println(ht);

		String str = ht.get("111-111");
		if( str == null || str.equals(""))
			System.out.println("자료없음");
		else
			System.out.println(str);
		
		if(ht.containsKey("222-222"))
			System.out.println("222-222 있다");
		else
			System.out.println("222-222 없다");
		
		if(ht.containsValue("박신혜")){
			System.out.println("박신혜 있다");
		}else{
			System.out.println("박신혜 없다");
		}
		
		ht.remove("222-222");
		
		if(ht.containsKey("222-222"))
			System.out.println("222-222 있다");
		else
			System.out.println("222-222 없다");
		
		Set<String> keySet = ht.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value = ht.get(key);
			System.out.println("key : " + key);
			System.out.println("value : " + value);
		}
		
	}

}
