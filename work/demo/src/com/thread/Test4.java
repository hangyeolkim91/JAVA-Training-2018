package com.thread;


// 스레드 우선순위

class MyThread4 extends Thread{
	
	private String name;
	
	public MyThread4(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<20; i++){
			System.out.println(name + " : " + i);
		}
		
	}
}

public class Test4 {

	public static void main(String[] args) {
		
		MyThread4 t1 = new MyThread4("A");
		MyThread4 t2 = new MyThread4("B");
		MyThread4 t3 = new MyThread4("C");

		//우선순위 종류
		System.out.println("MIN : "+ Thread.MIN_PRIORITY);
		System.out.println("NOR : " + Thread.NORM_PRIORITY);
		System.out.println("MAX : " + Thread.MAX_PRIORITY);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		
		t1.start();
		t2.start();
		t3.start();
	}

}
