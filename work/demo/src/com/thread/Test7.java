package com.thread;

/*
 *  인터럽트 : 우선순위가 높은 프로그램을 먼저 실행 시키고
 *  다시 돌아옴
 */


class MyThread7 extends Thread{
	private Thread next;
	
	public void setNext(Thread next){
		
		this.next = next;
		
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<20; i++){
			
			try {
				sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(getName() + " : " + i);
			if(next.isAlive())
				next.interrupt();//  다음 스레드를 깨워라
		}
	}
	
}

public class Test7 {

	public static void main(String[] args) {

		System.out.println("main 시작...");
		MyThread7 t1 = new MyThread7();
		MyThread7 t2 = new MyThread7();
		MyThread7 t3 = new MyThread7();
		
		t1.setNext(t2);
		t2.setNext(t3);
		t3.setNext(t1);
		
		t1.start();
		t2.start();
		t3.start();
		
		//t1.interrupt();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main 종료...");
	}

}
