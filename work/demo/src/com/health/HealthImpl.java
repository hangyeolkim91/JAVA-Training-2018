package com.health;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HealthImpl implements Health{

	private Map<String, Member> hMap = new HashMap<String, Member>();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void register() {
		
		System.out.println("회원 번호?");
		String mId = sc.next();
		
		if( hMap.containsKey(mId) ){
			System.out.println("이미 존재하는 회원입니다!");
			return;
		}
		Member member = new Member();
		
		System.out.println("이름?");
		member.setName(sc.next());
		
		System.out.println("나이?");
		member.setAge(sc.nextInt());
		
		System.out.println("성별 ?");
		member.setGender(sc.next());
		
		System.out.println("우편번호?");
		member.setZip(sc.next());
		
		System.out.println("주소?");
		member.setAddr(sc.next());
		
		System.out.println("몸무게?");
		member.setWeight(sc.nextInt());
		
		System.out.println("키?");
		member.setHeight(sc.nextInt());
		
		hMap.put(mId, member);
		System.out.println("입력성공!");
		
		
		
		
	}

	@Override
	public void showMembers() {
		Iterator<String> keyIterator = hMap.keySet().iterator();
		System.out.printf("%s %s %s %s %8s %8s %3s %s\n","번호","이름","나이","성별","우편번호","주소","몸무게", "키");
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Member value = hMap.get(key);
			System.out.printf("%s %s\n",key,value.toString());
		}
	}

	@Override
	public void delete() {
		System.out.println("삭제할 회원 번호?");
		String mId = sc.next();
		
		if( !hMap.containsKey(mId)){
			System.out.println("삭제할 회원 번호가 없습니다!");
			return;
		}
		
		hMap.remove(mId);
		System.out.println("삭제성공!");
	}

	@Override
	public void update() {
		
		System.out.println("수정할 회원 번호?");
		String mId = sc.next();
		
		if( !hMap.containsKey(mId)){
			System.out.println("수정할 회원 번호가 없습니다!");
			return;
		}
		
		Member member = hMap.get(mId);
		
		System.out.println("나이?");
		member.setAge(sc.nextInt());
		
		System.out.println("성별 ?");
		member.setGender(sc.next());
		
		System.out.println("우편번호?");
		member.setZip(sc.next());
		
		System.out.println("주소?");
		member.setAddr(sc.next());
		
		System.out.println("몸무게?");
		member.setWeight(sc.nextInt());
		
		System.out.println("키?");
		member.setHeight(sc.nextInt());
		
	}

	@Override
	public void searchByMemberId() {
		System.out.println("찾을 회원 번호?");
		String mId = sc.next();
		
		if( !hMap.containsKey(mId)){
			System.out.println("찾는 회원이 없습니다!");
			return;
		}
		Member member = hMap.get(mId);
		System.out.printf("%s %s\n",mId,member.toString());
	}

	@Override
	public void searchByMemberName() {
		System.out.println("찾을 회원 이름?");
		String name = sc.next();
		
		boolean flag = false;
		
		Iterator<String> it = hMap.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			Member member = hMap.get(key);
			if( member.getName().equalsIgnoreCase(name)){
				flag = true;
				System.out.printf("%s %s\n",key,member.toString());
			}
		}
		if(!flag)
			System.out.println("찾는 이름이 없습니다!");
	}

}
