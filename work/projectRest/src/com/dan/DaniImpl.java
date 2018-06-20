package com.dan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DaniImpl implements Danbi{
	
	
	private ArrayList<DanbiVO> lists = new ArrayList<DanbiVO>();
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void input() {
		
		int result =0;
		
		DanbiVO vo = new DanbiVO();
		
		System.out.println("이름은?");
		vo.setIname(sc.next());
		
		System.out.println("위치는?");
		vo.setIwitch(sc.next());
		
		System.out.println("메뉴는?");
		vo.setImenu(sc.next());
		
		System.out.println("가격은?");
		vo.setIprice(sc.next());
		
		lists.add(vo);
		
	}

	@Override
	public void print() {
		
		
		Iterator<DanbiVO> it = lists.iterator();
		
		
		while(it.hasNext()){
			DanbiVO vo= it.next();
			
			System.out.println(vo.toString());
		}
		
	}

	@Override
	public void save() {
		
		try {
			FileOutputStream fos = new FileOutputStream("d:\\doc\\danbi.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(lists);
			
			oos.close();
			System.exit(0);
			
		} catch (Exception e) {
			
		}
		
		
	}

	@Override
	public void end() {
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\danbi.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			lists = (ArrayList<DanbiVO>) ois.readObject();
			
			ois.close();
			
			System.exit(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
