package com.generic;

// ���ܸ� �ٽ� ������ ���

public class Test6 {

	public void value1(int value) throws Exception{
		try {
			value2(value);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("value1");
			System.out.println(e.toString());
		}
	}
	
	public void value2(int value) throws Exception{
		if(value<0)
			throw new Exception("0���� ���� ��!!");
	}
	
	public static void main(String[] args) {
		
		Test6 ob = new Test6();
		
		try {
			ob.value1(-10);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main...");
		}

	}

}
