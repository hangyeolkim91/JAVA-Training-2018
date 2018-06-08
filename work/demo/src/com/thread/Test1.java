package com.thread;

class MyThread1 extends Thread{
	
	private int num;
	private String name;
	
	public MyThread1(int num, String name){
		this.num = num;
		this.name = name;
		
	}
	
	@Override
	public void run() {//�������� �޼ҵ�
		int i=0;
		while(i < num){
			System.out.println(this.getName() + " : " + name + i);
			i++;
			
			try {
				//sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class Test1 {

	public static void main(String[] args) {

		System.out.println("main ����..");
		MyThread1 t1 = new MyThread1(100, "ù��°");
		MyThread1 t2 = new MyThread1(200, "�ι�°");
		
		t1.start();
		t2.start();
		
		//������� ����� ������ : 3 ( main, t1, t2);
		
		System.out.println("main ����...");
	}

}
