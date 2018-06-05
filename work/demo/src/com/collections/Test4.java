package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import javax.management.Query;

public class Test4 {

	public static void main(String[] args){ 
		
		Set<String> s = new HashSet<String>();
		
		s.add("����");
		s.add("�λ�");
		s.add("�뱸");
		s.add("�뱸");
		System.out.println(s);
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}

		System.out.println("------------------------------------------");
		
		Stack<String> st = new Stack<String>();
		st.push("����");
		st.push("����");
		st.push("�뱸");
		st.push("�λ�");
		
		while( !st.isEmpty()){
			System.out.println(st.pop());
		}
		
		System.out.println("------------------------------------------");
		
		Queue<String> q = new LinkedList<String>();
		
		q.offer("����");
		q.add("�λ�");
		q.add("daegu");
		q.offer("gwangju");
		
		while( q.peek() != null){
			System.out.println(q.poll());
		}
		
		System.out.println("------------------------------------------");
		
		List<String> list = new LinkedList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		
		List<String> list2 = new LinkedList<String>();
		
		list2.add("seoul");
		list2.add("busan");
		list2.add("daegu");
		list2.add("incheon");
		
		list2.addAll(list);
		
		for(String ss : list){
			System.out.print(ss + " ");
		}
		System.out.println();
		for(String ss : list2){
			System.out.print(ss + " ");
		}
		System.out.println();
		
		list2.subList(2, 5).clear();
		
		for(String ss : list2){
			System.out.print(ss + " ");
		}
		System.out.println();
		
		String[] str = {"��", "��", "��","��","��"};
		
		Arrays.sort(str);
		
		for(String ss : str){
			System.out.print(ss + " ");
		}
		System.out.println();
		
	}

}
