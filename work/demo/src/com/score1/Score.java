package com.score1;

import java.util.Scanner;

public class Score {
	
	int inwon;
	Record[] rec; // 초기값 = null
	Scanner sc = new Scanner(System.in);

	public void set(){
		
		do{
			System.out.println("인원수?");
			inwon = sc.nextInt();
		}while(inwon < 1 || inwon >10);
		
		rec = new Record[inwon];
		System.out.println(rec[0]);
		
	}
	
	public void input(){
		
		String[] title = {"국어?", "영어?","수학?"};
		
		for(int i=0; i<inwon; i++){
			
			rec[i] = new Record();
			
			System.out.println((i+1)+"번째 이름?");
			rec[i].name = sc.next();
			
			
			for(int j=0; j<rec[i].score.length; j++){
				
				System.out.println(title[j]);
				
				int score = sc.nextInt();
				
				rec[i].score[j]= score;
				rec[i].total += score;
			}
			rec[i].avg = rec[i].total/3;
			
		}
	}
	
	private void ranking(){
		
		for(int i=0; i<inwon; i++){
			rec[i].rank = 1;
		}
		
		for(int i=0; i<inwon-1; i++){
			for(int j=i+1; j<inwon; j++){
				
				if( rec[i].total > rec[j].total){
					rec[j].rank++;
				}else if ( rec[i].total < rec[j].total){
					rec[i].rank++;
				}
			}
		}
		
	}
	
	public void print(){
		
		ranking();
		
		for(int i=0; i<inwon; i++){
			
			System.out.printf("%6s", rec[i].name);
			
			for(int j=0; j<3; j++){
				System.out.printf("%4d", rec[i].score[j]);
			}
			
			System.out.printf("%4d %4d %4d\n", rec[i].total, rec[i].avg, rec[i].rank);
		}
	}
}
