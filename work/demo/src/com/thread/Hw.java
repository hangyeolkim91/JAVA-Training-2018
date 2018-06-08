package com.thread;

import java.util.Random;
import java.util.Scanner;

class Thinking extends Thread{
	
/*	private Thread next;
	
	public void setNext(Thread next){
		this.next = next;
	}*/
	
	@Override
	public void run() {
		
		System.out.print("∞ÌπŒ¡ﬂ");
		
		for( int i=0; i<20; i++){
			
			try {
				sleep(250);
				System.out.print(".");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println();
		System.out.println();
		/*if(next.isAlive())
			next.interrupt();*/
		
	}
}

class Picker extends Thread{
	private String[] name = 
		{"¿Âøπ¡¯","≥Î»´«ˆ","√÷ø¯∞Ê","∂Ûøµ¡ÿ","º€¿Á»∆",
		"¡§¿Á»∆","¿Âº∫¡¯","«—Ω¬¥ˆ","∑˘¡§æ∆","¿Ã«ˆ¡¯",
		"±Ë¥©∏Æ","¡∂¿œ¡ÿ","±ËøÎ±§","π⁄¡æ»∆","º≠øµ¡¯",
		"¿ÃæÁ±‘","±Ë»ÒπŒ","π⁄«ˆ¿Á","±Ë«—∞·","ø©¡§πŒ",
		"¿”¥‹∫Ò","±Ë«ÿ≥™","πÆΩ¬¡ÿ","¡∂±‚«ˆ","π⁄ø¯∫Û",
		"±ËπŒøµ","¿Ã≈¬«ˆ","π⁄∏Ìº∫","«„µµ»÷","Ω≈ªÛø±"};
	
	private int n;
	
	public void setPeople(){
		System.out.println("πﬂ«• ¿Œø¯?");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
	}
	
	@Override
	public void run() {
		
		Random rd = new Random();
		
		int[] rand = new int[n];
		int idx = 0;
		while(idx <n){
		
			rand[idx] = rd.nextInt(30);
			idx++;
			for( int i=0; i<idx-1; i++){
				if( rand[i] == rand[idx-1]){
					idx--;
					break;
				}
			}
		}

		/*try {
			
			sleep(50000);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}*/
		System.out.println("√‡«œ«’¥œ¥Ÿ!!, πﬂ«•¿⁄¿‘¥œ¥Ÿ.\n");
		for(int i=0; i<n; i++){
			System.out.println((i+1)+"π¯ πﬂ«•¿⁄ :    " + name[rand[i]]);
			
		}
		
		
		
	}
	
}

public class Hw {
	


	public static void main(String[] args) {
		
		Picker t1 = new Picker();
		Thinking t2 = new Thinking();
		
		//t2.setNext(t1);
		
		t1.setPeople();
		t2.start();
		
		try {
			t2.join();
			t1.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

	}

}
