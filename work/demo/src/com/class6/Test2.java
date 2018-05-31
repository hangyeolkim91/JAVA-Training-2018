package com.class6;


class SuperTest{
	
	public int a =10, b=20;
	
	public void write(){
		System.out.println("슈퍼클래스 write() 메소드");
	}
	
	public int hap(){
		return a+b;
	}
}

class SubTest extends SuperTest{
	
	public int b=100, c=200;
	
	public void print(){
		System.out.println("서브 클래스 print() 메소드");
	}
	
	@Override
	public int hap() {
		return a+b+c;
	}
}

public class Test2 {

	public static void main(String[] args) {
		
		SuperTest parent = new SuperTest();
		
		SuperTest st = new SubTest();
		
		SubTest child = (SubTest) st;
		
		
		
		child.print();
		child.write();
		
		parent.write();
		System.out.println("parent.hap()" + parent.hap());
		
		System.out.println("st.hap()"+st.hap());
		System.out.println("child.hap()" + child.hap());
		

		
	}

}
