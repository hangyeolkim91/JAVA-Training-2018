package com.score4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ScoreImpl implements Score{

	//private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();
	private Scanner sc = new Scanner(System.in);
	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>(); // �������� ����
	
	@Override
	public void input() {
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("�й�?");
		String sid = sc.next();
		
		if(searchSid(sid)){
			System.out.println("�й��� ���� �մϴ�.!");
			return;
		}
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("����?");
		vo.setKor(sc.nextInt());
		
		System.out.println("����?");
		vo.setEng(sc.nextInt());
		
		System.out.println("����?");
		vo.setMath(sc.nextInt());
		
		
		hMap.put(sid, vo);
	}

	@Override
	public boolean searchSid(String sid) {
		
		return hMap.containsKey(sid);
		
	}

	@Override
	public void print() {
		
		System.out.printf("%5s %s %s %s %s %s %s\n", "�й�", "�̸�","����","����","����","����","���" );
		System.out.println("=======================================");
		Iterator<String> it = hMap.keySet().iterator();
		
		while(it.hasNext()){
			String key = it.next();
			ScoreVO vo = hMap.get(key);
			System.out.printf("%6s %s\n" ,key , vo.toString());
			
		}
	}

	@Override
	public void delete() {
		System.out.println("���� �� �й�?");
		String sid = sc.next();
		if(!searchSid(sid)){
			System.out.println("�й��� ���� �����ʽ��ϴ�!");
			return;
		}
		hMap.remove(sid);
		
	}

	@Override
	public void update() {
		System.out.println("������ �й�?");
		String sid = sc.next();
		if(!searchSid(sid)){
			System.out.println("�й��� ���� �����ʽ��ϴ�!");
			return;
		}
		ScoreVO vo = hMap.get(sid);
		
		System.out.println("����?");
		vo.setKor(sc.nextInt());
		
		System.out.println("����?");
		vo.setEng(sc.nextInt());
		
		System.out.println("����?");
		vo.setMath(sc.nextInt());
		
		
		//hMap.put(sid, vo);
		
	}

	@Override
	public void findSid() {
		System.out.println("ã�� �й�?");
		String sid = sc.next();
		
		if(!searchSid(sid)){
			System.out.println("�й��� ���� �����ʽ��ϴ�!");
			return;
		}
		
		ScoreVO vo = hMap.get(sid);
		System.out.printf("%6s %s",sid,vo.toString());
		
	}

	@Override
	public void findName() {
		System.out.println("ã�� �̸�?");
		String name = sc.next();
		boolean flag = false;
		
		Iterator<String> it = hMap.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			ScoreVO vo = hMap.get(key);
			
			if( vo.getName().equalsIgnoreCase(name)){
				System.out.printf("%6s %s\n",key,vo.toString());
				flag = true;
			}
		}
		
		if( !flag){
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	}

}
