package com.swing;

/*
 * Class Ŭ����
 * 
 * Ư�� Ŭ������ �������̽��� ������ �˻� �� �� �ִ�
 * �޼ҵ带 ����
 */

class Test{
	public void write(){
		System.out.println("�׽�Ʈ...");
		
	}
}

public class Test3 {
	
	public static void main(String[] args){
		
		try {
			
			Class<?> c = Class.forName("com.swing.Test");
			
			Object ob = c.newInstance(); //��ü ����
			
			Test t = (Test) ob;
			
			t.write();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		
	}

}
