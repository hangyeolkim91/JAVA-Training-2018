package com.naver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NaverImpl implements Naver{

	List<NaverVO> list = new ArrayList<NaverVO>();
	Scanner sc = new Scanner(System.in);
	NaverAuthen naverAuthenticator = new NaverAuthen();
	
	@Override
	public void input() {
		
		NaverVO vo = new NaverVO();
		
		
		try {
			System.out.println("아이디?[8-15자 이내 영문자와 숫자 혼용]");
			String id = sc.next();
			
			naverAuthenticator.id(id);
			vo.setId(id);
			
			System.out.println("비밀번호?");
			String pw1 = sc.next();
			
			System.out.println("비밀번호확인?");
			String pw2 = sc.next();
			
			naverAuthenticator.pwCheck(pw1, pw2);
			
			vo.setPw1(pw1);
			
			System.out.println("이름?");
			vo.setName(sc.next());
			
			System.out.println("성별?");
			vo.setGender(sc.next());
			
			System.out.println("생년월일?");
			vo.setBirth(sc.next());
			
			System.out.println("이메일 ?");
			vo.setEmail(sc.next());
			
			System.out.println("휴대전화번호?");
			vo.setTel(sc.next());
			
			list.add(vo);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
	}

	@Override
	public void print() {
		
		Iterator<NaverVO> it = list.iterator();
		
		while(it.hasNext()){
			NaverVO vo = it.next();
			System.out.println(vo.toString());
		}
	}

	@Override
	public void searchById(String id) {
		Iterator<NaverVO> it = list.iterator();
		
		while(it.hasNext()){
			NaverVO vo = it.next();
			
			if( vo.getId().equals(id)){
				System.out.println(vo.toString());
				break;
			}
			
		}
	}

	@Override
	public void searchByName(String name) {
		
		Iterator<NaverVO> it = list.iterator();
		
		while(it.hasNext()){
			NaverVO vo = it.next();
			
			if( vo.getName().equals(name)){
				System.out.println(vo.toString());
				
			}
			
		}
	}

	@Override
	public void delete(String id) {
		
		Iterator<NaverVO> it = list.iterator();
		
		int index =-1;
		
		while(it.hasNext()){
			NaverVO vo = it.next();
			
			if( vo.getId().equals(id)){
				index = list.indexOf(vo);
			}
			
		}
		if( index == -1){
			System.out.println("지울 아이디가 없습니다.");
		}else{
			list.remove(index);
		}
	}

}
