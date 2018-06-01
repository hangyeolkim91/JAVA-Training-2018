package com.class7;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;

public class Test7 {

	private static final String city[] = {"����","�λ�","�뱸","��õ","����","����","���"};
	
	public static void main(String[] args) {

		Vector<String> v = new Vector<String>();
		String str;
		
		System.out.println("������ �ʱ� �뷮 : " + v.capacity());
		
		for(String s : city){
			v.add(s);
		}
		
		System.out.println("[Iterator] �� ����� ��ü ���");
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("������(���) ���� : " + v.size());
		
		v.set(0, "Seoul");
		v.set(1,"Pusan");
		//v.setElementAt("Incheon", 2);
		Iterator<String> it = v.iterator();
		
		while( it.hasNext()){
			String s = it.next();
			System.out.print(s+" ");
		}
		System.out.println();
		
		v.insertElementAt("���ѹα�", 0);
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		int index = v.indexOf("�뱸");
		
		if( index != -1){
			System.out.println("�˻� ���� : " + index);
		}else{
			System.out.println("�˻� ����!");
		}
		
		Collections.sort(v);
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		Collections.sort(v, Collections.reverseOrder());
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		v.remove("Pusan");
		v.remove(0);
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		for(int i=0; i<20; i++){
			v.add(" "+i);
		}
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println("\n");
		
		System.out.println("������ �뷮 : " + v.capacity());
		System.out.println("������ ũ�� : " + v.size());
		
		for(int i=0; i<10; i++){
			v.remove(5);
		}
		
		
		for(Iterator<String> i = v.iterator() ; i.hasNext();){
			String s = i.next();
			System.out.print(s + " ");
		}
		System.out.println("\n");
		
		v.trimToSize();
		System.out.println("������ �뷮 : " + v.capacity());
		System.out.println("������ ũ�� : " + v.size());
		
		v.clear();
		System.out.println("������ �뷮 : " + v.capacity());
		System.out.println("������ ũ�� : " + v.size());
		
		v.trimToSize();
		System.out.println("������ �뷮 : " + v.capacity());
		System.out.println("������ ũ�� : " + v.size());
	}

}
