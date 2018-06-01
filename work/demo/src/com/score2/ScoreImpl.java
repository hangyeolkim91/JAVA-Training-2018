package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score{
	
	private int numOfStd;
	private Record[] rec;
	Scanner sc = new Scanner(System.in);

	@Override
	public void set() {
		
		
		do{
			System.out.println("학생 수?");
			numOfStd = sc.nextInt();
		}while(numOfStd < 1 || numOfStd > 10);
		
		rec = new Record[numOfStd];
		
	}

	@Override
	public void input() {
		String[] sub = {"국어?", "영어?", "수학?"};
		
		for(int i=0; i<numOfStd; i++){
			rec[i] = new Record();
			System.out.println("이름?");
			rec[i].name = sc.next();
			
			System.out.println("학번?");
			rec[i].sid = sc.next();
			
			System.out.println(sub[0]);
			rec[i].kor = sc.nextInt();
			
			System.out.println(sub[1]);
			rec[i].eng = sc.nextInt();
			
			System.out.println(sub[2]);
			rec[i].mat = sc.nextInt();
			
			rec[i].total = rec[i].kor + rec[i].eng + rec[i].mat;
			rec[i].avg = rec[i].total/3;
			
		}
	}
	
	private String grade(int score){
		
		String g="";
		
		switch(score/10){
		case 10:
		case 9:
			g = "수";
			break;
		case 8:
			g = "우";
			break;
		case 7:
			g = "미";
			break;
		case 6 :
			g = "양";
			break;
		default:
			g = "가";
			
			
		}
		return g;
	}

	@Override
	public void print() {
		
		for(Record r : rec){
			System.out.printf("학번 : %s\n이름 : %s \n\n 국어 :%d (%s) 영어 : %d (%s) 수학: %d (%s) 총점 : %d 평균: %d\n", r.sid,r.name,r.kor,grade(r.kor),r.eng,grade(r.eng), r.mat, grade(r.mat), r.total, r.avg);
		}
	}
	
	

}
