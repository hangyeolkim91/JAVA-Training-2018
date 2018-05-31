package com.class4;

class Test{
	private int a = 10;
	
	@Override
	public boolean equals(Object arg0) {
		Test a = (Test) arg0;
		return this.a == a.a;
	}

	public void write(){
		System.out.println("a : " + a);
	}
}

public class Test2 { // extends Object

	public static void main(String[] args) {

		Test ob1 = new Test();
		Test ob2 = new Test();
		
		System.out.println("ob1 == ob2 : " + (ob1==ob2));
		
		//Object의 equals는 주소를 비교한다.
		System.out.println("ob1.equals( ob2 ): " + ob1.equals(ob2));
		
		// 주소값 출력 hash code
		System.out.println("ob1 : " + ob1);
		System.out.println(ob1.toString());
		System.out.println(ob2.toString());
	}

}
