package com.class5;



class SuperClass{
	
	protected int a = 10 , b = 20;
	
	public void write(){
		System.out.println("Super class write()...");
		System.out.println("a: "+ a + ", b : " + b);
	}
}

class SubClass extends SuperClass{
	
	protected int b = 30, c = 40;

	@Override
	public void write() {
		System.out.println("Sub class write() ...");
		System.out.println("a: "+ a + ", b : " + b + " , c: " + c);
		System.out.println("super.b : " + super.b);
	}
	
	public void print1(){
		System.out.println("Sub class print1()...");
		write();
		
		
	}
	public void print2(){
		System.out.println("Sub class print2()..");
		super.write();
		
	}
	
	
}

public class Test4 {

	public static void main(String[] args) {
		
		SubClass ob = new SubClass();
		
		SuperClass superClass = new SuperClass();
		
		SuperClass sc = ob;
		
		sc.write();
		
		
		/*ob.write();
		
		ob.print1();
		
		ob.print2();
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("ob.b : " + ob.b);
		
		System.out.println("( (SuperClass)ob).b : " + ( (SuperClass)ob).b); //UPCAST
*/		
		
		
		// 메소드는 인스턴스변수와 다르게 자신의 메소드를 호출
		// 메소드는 heap영역이 아닌 메소드 영역에 저장되어있기 때문에
		// 접근이 불가 하다
		// 메소드는 UPCAST해도 무조건 자신것을 사용한다.
		/*((SuperClass)ob).write();
		
		((SubClass)superClass).write();*/
		
		//sc.write();
		
		//sc.print1(); 안됨
		
		/*SubClass child = (SubClass) sc;
		child.print1();*/
	}

}
