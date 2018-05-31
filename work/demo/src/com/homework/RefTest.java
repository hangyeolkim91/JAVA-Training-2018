package com.homework;

class A{
	private int a= 5;
	
	public void plusOne(){
		a++;
	}
	public int getNum(){
		return a;
	}
}

public class RefTest {
	public static void change(StringBuilder x) {
		//x = new StringBuilder( "cd");
		x.append("cd");
	}

	public void changeValue(int a){
		a = a+1;
		
		System.out.println(a);
	}
	
	public void changeValue(Integer a){
		a = a+a;
		System.out.println(a);
	}
	
	public void changeValue(String s){
		s += "a";
		//String s1 ="str";
		//System.out.println(s1 == s);
	}
	
	public void changeValue(A a){
		a.plusOne();
	}
	
	public static void main(String[] args) {

		int a = 10;
		Integer b = new Integer(5);
		//System.out.println("b.toString()" + b.getClass());
		RefTest rt = new RefTest();
		String s = new String("str");
		//rt.changeValue(a);
		
		//System.out.println(a);
		rt.changeValue(b);
		System.out.println(b);
		
		rt.changeValue(s);
		System.out.println(s);

		A oba = new A();
		//RefTest rt = new RefTest();
		System.out.println(oba.getNum());
		rt.changeValue(oba);
		System.out.println(oba.getNum());
		
		StringBuilder x = new StringBuilder("ab");
		change(x);
		System.out.println(x);
		
	}

}
