package com.class2;

// static
// 자기가 알아서 메모리로 올라감
// 인스턴스 1000개를 만들어도 메모리 공간은 한개만 사용



public class Test2 {

	public static int a = 10;  // class 변수
	// 클래스 변수나 클래스 메소드는  프로그램이 로딩 되는순간 
	// 메모리 할당 됨 [클래스이름.객체이름]으로 접근 가능
	// 즉 new를 사용하지 않고 바로 사용 할 수 있다.
	
	private int b = 20;       //instance 변수
	// 동일한 클래스의 instance 메소드 안에서 바로 접근이 가능 하지만
	// 클래스 메소드에서는 접근 할 수 없다.
	// 클래스 메소드에서 접근하기위해서는 new를 통해 
	// 객체를 생성하고 객체 이름으로만 접근이 가능하다.
	
	// instance 메소드
	public void write(){ 
		
		System.out.println("class 변수 : " + a);
		System.out.println("instance 변수 : "+ b);
		
	}
	
	//class 메소드
	public static void print(){
		
		System.out.println("class 변수 : " + a);
		
		//System.out.println("instance 변수 : "+ b); 불가능함
	}
	
	//class 메소드
	public static void main(String[] args) {
		
		System.out.println("class 변수 a : " + a);
		
		System.out.println("class 변수 Test2.a" + Test2.a);
		
		Test2.print();
		
		Test2 ob1 = new Test2();
		
		System.out.println("instance 변수 : " + ob1.b);
		
		ob1.write();
		
		//ob1.print(); class method, class var는 이런식으로는 사용하지 않는다.(실행 o)
		//ob1.a;
		
		/*Test2 ob = new Test2();
		ob.main(args);*/
		
		Test2 ob2 = new Test2();
		ob2.a = 100;
		ob2.b =200;
		System.out.println("ob2 ---------------------------------");
		ob2.write();
		ob2.print();
		
		Test2 ob3 = new Test2();
		System.out.println("ob3 ---------------------------------");
		ob3.write();
		ob3.print();
		
		
	}

}
