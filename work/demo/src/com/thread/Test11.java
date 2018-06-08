package com.thread;

public class Test11 {

	public static void main(String[] args) {
		
		System.out.println("메인 스레드 그룹 : " + Thread.currentThread().getThreadGroup());
		
		System.out.println("메인 스레드 이름 : " + Thread.currentThread());
		
		Thread t1 = new Thread();
		
		System.out.println("t1 스레드 그룹 : " + t1.getThreadGroup());
		
		// 스레드 이름, 우선순위, 그룹명
		System.out.println("t1 스레드 이름 : " + t1);
		
		System.out.println("-------------------------------------------------------");
		
		ThreadGroup tg = new ThreadGroup("suzi");
		
		Thread t2 = new Thread(tg,"t2");
		Thread t3 = new Thread(tg,"t3");
		
		System.out.println(tg);
		System.out.println("t2 : " + t2);
		System.out.println("t3 : " + t3);
		

	}

}
