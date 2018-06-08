package com.thread;

import java.util.Calendar;

class Tclock implements Runnable{

	@Override
	public void run() {
		
		while(true){
			System.out.printf("%1$tF %1$tT\n", Calendar.getInstance());
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		

		
	}
	
}

public class Test3 {

	public static void main(String[] args) {

		Thread t1 = new Thread( new Tclock());
		t1.start();
		
	}

}
