package com.collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/*
 * collection
 * Map <Ű, ��>
 * HashTable : ����ȭ ���� 
 * HashMap
 * 
 * Ű�� �ߺ����� ���� ���� �� ���� ( Ű�� set )
 * Ű�� ���� �ߺ��Ǹ� ������ ���� ����ȴ�(����)
 */

public class Test3 {

	public static final String[] name ={"�����", "õ����", "������", "����ȿ", "�ڽ���"};
	public static final String[] tel = {"111-111", "222-222","333-333","111-111","444-444"};
	
	public static void main(String[] args) {
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		for(int i=0; i<name.length; i++){
			ht.put(tel[i],name[i]);
		}
		
		System.out.println(ht);

		String str = ht.get("111-111");
		if( str == null || str.equals(""))
			System.out.println("�ڷ����");
		else
			System.out.println(str);
		
		if(ht.containsKey("222-222"))
			System.out.println("222-222 �ִ�");
		else
			System.out.println("222-222 ����");
		
		if(ht.containsValue("�ڽ���")){
			System.out.println("�ڽ��� �ִ�");
		}else{
			System.out.println("�ڽ��� ����");
		}
		
		ht.remove("222-222");
		
		if(ht.containsKey("222-222"))
			System.out.println("222-222 �ִ�");
		else
			System.out.println("222-222 ����");
		
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
