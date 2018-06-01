package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score{
	
	private int numOfStd;
	private Record[] rec;
	Scanner sc = new Scanner(System.in);

	@Override
	public void set() {
		
		
		do{
			System.out.println("�л� ��?");
			numOfStd = sc.nextInt();
		}while(numOfStd < 1 || numOfStd > 10);
		
		rec = new Record[numOfStd];
		
	}

	@Override
	public void input() {
		String[] sub = {"����?", "����?", "����?"};
		
		for(int i=0; i<numOfStd; i++){
			rec[i] = new Record();
			System.out.println("�̸�?");
			rec[i].name = sc.next();
			
			System.out.println("�й�?");
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
			g = "��";
			break;
		case 8:
			g = "��";
			break;
		case 7:
			g = "��";
			break;
		case 6 :
			g = "��";
			break;
		default:
			g = "��";
			
			
		}
		return g;
	}

	@Override
	public void print() {
		
		for(Record r : rec){
			System.out.printf("�й� : %s\n�̸� : %s \n\n ���� :%d (%s) ���� : %d (%s) ����: %d (%s) ���� : %d ���: %d\n", r.sid,r.name,r.kor,grade(r.kor),r.eng,grade(r.eng), r.mat, grade(r.mat), r.total, r.avg);
		}
	}
	
	

}
