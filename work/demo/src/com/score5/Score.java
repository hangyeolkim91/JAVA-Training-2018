package com.score5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score {
	
	private List<ScoreVO> list;
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "/data/score.txt");
	
	public Score() {
		
		try {
			
			if( !f.getParentFile().exists()){
				f.getParentFile().mkdirs();
					
			}
			if( f.exists() ){
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				
				list = (List<ScoreVO>) ois.readObject();
				ois.close();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void writeFile(){
		
		try{
			
			if( list != null){
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				
				oos.writeObject(list);
				
				oos.close();
				
				System.out.println("파일 저장 성공!");
				
			}
		}catch(Exception e){
			
		}
	}
	
	public void print(){
		
		if(list == null)
			return;
		
		Iterator<ScoreVO> it = list.iterator();
		
		while(it.hasNext()){
			ScoreVO vo = it.next();
			
			System.out.println(vo.toString());
		}
	}
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("생년월일?");
		vo.setBirth(sc.next());
		
		System.out.println("점수?");
		vo.setScore(sc.nextInt());
		
		if(list == null)
			list = new ArrayList<ScoreVO>();
		list.add(vo);
	}
	
}
