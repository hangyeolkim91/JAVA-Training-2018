package com.score4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ScoreImpl implements Score{

	//private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();
	private Scanner sc = new Scanner(System.in);
	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>(); // 오름차순 정렬
	
	@Override
	public void input() {
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("학번?");
		String sid = sc.next();
		
		if(searchSid(sid)){
			System.out.println("학번이 존재 합니다.!");
			return;
		}
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMath(sc.nextInt());
		
		
		hMap.put(sid, vo);
	}

	@Override
	public boolean searchSid(String sid) {
		
		return hMap.containsKey(sid);
		
	}

	@Override
	public void print() {
		
		System.out.printf("%5s %s %s %s %s %s %s\n", "학번", "이름","국어","영어","수학","총점","평균" );
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
		System.out.println("삭제 할 학번?");
		String sid = sc.next();
		if(!searchSid(sid)){
			System.out.println("학번이 존재 하지않습니다!");
			return;
		}
		hMap.remove(sid);
		
	}

	@Override
	public void update() {
		System.out.println("수정할 학번?");
		String sid = sc.next();
		if(!searchSid(sid)){
			System.out.println("학번이 존재 하지않습니다!");
			return;
		}
		ScoreVO vo = hMap.get(sid);
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMath(sc.nextInt());
		
		
		//hMap.put(sid, vo);
		
	}

	@Override
	public void findSid() {
		System.out.println("찾을 학번?");
		String sid = sc.next();
		
		if(!searchSid(sid)){
			System.out.println("학번이 존재 하지않습니다!");
			return;
		}
		
		ScoreVO vo = hMap.get(sid);
		System.out.printf("%6s %s",sid,vo.toString());
		
	}

	@Override
	public void findName() {
		System.out.println("찾을 이름?");
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
			System.out.println("찾는 이름이 없습니다.");
		}
	}

}
