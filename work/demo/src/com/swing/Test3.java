package com.swing;

/*
 * Class 클래스
 * 
 * 특정 클래스나 인터페이스의 정보를 검색 할 수 있는
 * 메소드를 제공
 */

class Test{
	public void write(){
		System.out.println("테스트...");
		
	}
}

public class Test3 {
	
	public static void main(String[] args){
		
		try {
			
			Class<?> c = Class.forName("com.swing.Test");
			
			Object ob = c.newInstance(); //객체 생성
			
			Test t = (Test) ob;
			
			t.write();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		
	}

}
