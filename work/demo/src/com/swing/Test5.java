package com.swing;

import java.lang.reflect.Method;

/*
 * Reflect�� ����� �޼ҵ� ȣ����
 */

class Exam{
	
	public Integer sum(Integer a, Integer b){
		return a+b;
	}
	
	public int sub(int a, int b){
		return a-b;
	}
	
	public void write(String title, int result){
		System.out.println(title + " : " + result);
	}
}


public class Test5 {

	public static void main(String[] args) throws Exception {

		Class cls = Class.forName("com.swing.Exam");
		
		//Ŭ������ ��ü ����
		
		Object ob = cls.newInstance();
		
		//sum method
		
		Method sum = cls.getDeclaredMethod("sum", new Class[]{Integer.class, Integer.class});
		
		Method sub = cls.getDeclaredMethod("sub", new Class[]{int.class, int.class});
		
		Method write = cls.getDeclaredMethod("write", new Class[]{String.class, int.class});
		
		//�μ��� ���ٸ�
//		Method write = cls.getDeclaredMethod("write", null);
		
		Object s = sum.invoke(ob, new Object[]{20,10});
		
		write.invoke(ob, new Object[]{"�� : ",s});
		
		Integer i = (Integer)sub.invoke(ob, new Object[]{100,200});
		
		write.invoke(ob, new Object[]{"�� : ",i});
		
		// �μ��� ���ٸ�
//		write.invoke(ob,null);
	}

}
