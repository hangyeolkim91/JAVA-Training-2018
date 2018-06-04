package com.score3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {
	
	private List<ScoreVO> lists = new ArrayList<ScoreVO>();
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public int input() {
		
		int result = 0;
		
		
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("�й�?");
		vo.setSid(sc.next());
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("����?");
		vo.setKor(sc.nextInt());
		
		System.out.println("����?");
		vo.setEng(sc.nextInt());
		
		System.out.println("����?");
		vo.setMath(sc.nextInt());
		
		lists.add(vo);
		
		return result;
	}

	@Override
	public void print() {
		
		System.out.printf("%5s %s %s %s %s %s %s\n", "�й�", "�̸�","����","����","����","����","���" );
		System.out.println("=======================================");
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()){
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
			
		}
	}

	@Override
	public void searchSid() {
		System.out.println("�˻��� �й�?");
		String searchSid  = sc.next();
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()){
			ScoreVO vo = it.next();
			if( vo.getSid().equals(searchSid)){
				System.out.println(vo.toString());
			}
		}
	}

	@Override
	public void searchName() {
		
		System.out.println("�˻��� �̸�?");
		String searchName  = sc.next();
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()){
			ScoreVO vo = it.next();
			if( vo.getName().equals(searchName)){
				System.out.println(vo.toString());
			}
		}
	}

	@Override
	public void descSortTotal() {
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				
				return o2.getTotal() - o1.getTotal();
			}
		};
		
		lists.sort(comp);
		print();
	}

	@Override
	public void ascSortSid() {
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				
				return o1.getSid().compareTo(o2.getSid());
			}
		};
		
		lists.sort(comp);
		
		print();
	}

}
