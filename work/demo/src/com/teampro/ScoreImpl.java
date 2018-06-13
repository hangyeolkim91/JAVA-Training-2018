package com.teampro;


import java.awt.TextArea;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class ScoreImpl implements Score{

	List<ScoreVO> list = new ArrayList<ScoreVO>();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void init() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teampro.txt"));
			/*ScoreVO vo;
			while((vo = (ScoreVO)ois.readObject()) != null){
				
				list.add(vo);
				
			}*/
			list = (List<ScoreVO>)ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void saveAndExit() {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teampro.txt"));
/*			Iterator<ScoreVO> it = list.iterator();
			while(it.hasNext()){
				oos.writeObject(it.next());
			}*/
			oos.writeObject(list);
			oos.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void print() {
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()){
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
	}
	@Override
	public void print(TextArea ta) {
		ta.setText("이름\t생일\t점수\n");
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()){
			ScoreVO vo = it.next();
			ta.append(vo.toString()+"\n");
		}
	}

	@Override
	public void input() {
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("생일 ?");
		vo.setBirth(sc.next());
		
		System.out.println("점수 ? ");
		vo.setScore(sc.nextInt());
		
		list.add(vo);
	}
	
	@Override
	public void input(ScoreVO vo) {
		list.add(vo);
		
		
	}



}
