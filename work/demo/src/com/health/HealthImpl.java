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
		
		System.out.println("ȸ�� ��ȣ?");
		String mId = sc.next();
		
		if( hMap.containsKey(mId) ){
			System.out.println("�̹� �����ϴ� ȸ���Դϴ�!");
			return;
		}
		Member member = new Member();
		
		System.out.println("�̸�?");
		member.setName(sc.next());
		
		System.out.println("����?");
		member.setAge(sc.nextInt());
		
		System.out.println("���� ?");
		member.setGender(sc.next());
		
		System.out.println("�����ȣ?");
		member.setZip(sc.next());
		
		System.out.println("�ּ�?");
		member.setAddr(sc.next());
		
		System.out.println("������?");
		member.setWeight(sc.nextInt());
		
		System.out.println("Ű?");
		member.setHeight(sc.nextInt());
		
		hMap.put(mId, member);
		System.out.println("�Է¼���!");
		
		
		
		
	}

	@Override
	public void showMembers() {
		Iterator<String> keyIterator = hMap.keySet().iterator();
		System.out.printf("%s %s %s %s %8s %8s %3s %s\n","��ȣ","�̸�","����","����","�����ȣ","�ּ�","������", "Ű");
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Member value = hMap.get(key);
			System.out.printf("%s %s\n",key,value.toString());
		}
	}

	@Override
	public void delete() {
		System.out.println("������ ȸ�� ��ȣ?");
		String mId = sc.next();
		
		if( !hMap.containsKey(mId)){
			System.out.println("������ ȸ�� ��ȣ�� �����ϴ�!");
			return;
		}
		
		hMap.remove(mId);
		System.out.println("��������!");
	}

	@Override
	public void update() {
		
		System.out.println("������ ȸ�� ��ȣ?");
		String mId = sc.next();
		
		if( !hMap.containsKey(mId)){
			System.out.println("������ ȸ�� ��ȣ�� �����ϴ�!");
			return;
		}
		
		Member member = hMap.get(mId);
		
		System.out.println("����?");
		member.setAge(sc.nextInt());
		
		System.out.println("���� ?");
		member.setGender(sc.next());
		
		System.out.println("�����ȣ?");
		member.setZip(sc.next());
		
		System.out.println("�ּ�?");
		member.setAddr(sc.next());
		
		System.out.println("������?");
		member.setWeight(sc.nextInt());
		
		System.out.println("Ű?");
		member.setHeight(sc.nextInt());
		
	}

	@Override
	public void searchByMemberId() {
		System.out.println("ã�� ȸ�� ��ȣ?");
		String mId = sc.next();
		
		if( !hMap.containsKey(mId)){
			System.out.println("ã�� ȸ���� �����ϴ�!");
			return;
		}
		Member member = hMap.get(mId);
		System.out.printf("%s %s\n",mId,member.toString());
	}

	@Override
	public void searchByMemberName() {
		System.out.println("ã�� ȸ�� �̸�?");
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
			System.out.println("ã�� �̸��� �����ϴ�!");
	}

}
