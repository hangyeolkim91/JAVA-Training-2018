package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * List(I) - ArrayList(C)
 * Vector���� ������ ���� ( ����ȭ�� �ȵ� )
 * 
 */

public class Test2 {

	public static void main(String[] args) {

		ArrayList<String> lists = new ArrayList<String>();
		lists.add("����");
		lists.add("�λ�");
		lists.add("�뱸");
		
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
		
		list1.add("��õ");
		
		int n = list1.indexOf("�λ�");
		list1.add(n+1,"����");
		
		for(String c : list1){
			System.out.print(c);
		}
		System.out.println();
		list1.add("�ڹ����α׷���");
		list1.add("�����ӿ�ũ");
		list1.add("��Ʈ����");
		list1.add("�ڹٶ�?");
		list1.add("������");
		
		String str ;
		
		for( Iterator<String> it2 = list1.iterator(); it2.hasNext();){
			str = it2.next();
			if(str.startsWith("�ڹ�")){
				System.out.println(str);
			}
		}
	}

}
