package com.thread;


// 동기화 블럭

class MyThread8 implements Runnable{
	
	private int bank = 10000;
	
	private int getBank(){
		return bank;
	}
	
	private int drawMoney(int m){
		bank -=m; //인출
		return m; // 인출 금액
	}
	
	
	
	
	@Override
	public void run() {
		
		int money_need = 6000;
		
		int money;
		String str = "";
		
		
		try {
			
			synchronized (this) {		
				
				if(getBank() >= money_need){
					
					Thread.yield();
					
					money = drawMoney(money_need);
					str = "인출 성공";
				}else{
					money = 0;
					str = "인출 실패";
				}
				
				System.out.println(Thread.currentThread().getName() + str + ", 인출 금액 : " + money + ", 잔고 : " + getBank());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

public class Test8 {

	public static void main(String[] args) {

		MyThread8 ob = new MyThread8();
		
		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();
		
	}

}
