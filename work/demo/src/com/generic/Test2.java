package com.generic;

class Box2<T>{
	
	private T t;
	
	public void set(T t){
		
		this.t = t;
	}
	
	public T get(){
		
		return t;
	}
	
	public <U> void print (U u){ // 메소드에서만 사용하는 제네릭
		
		System.out.println(u);
		System.out.println("t 클래스 : " + t.getClass().getName());
		System.out.println("u 클래스 : " + u.getClass().getName());
		
		
	}
}

public class Test2 {

	public static void main(String[] args) {

		Box2<Integer> b = new Box2<Integer>();
		
		b.set(new Integer(30));
		//b.print(new Integer(30));
		b.print("test");
	}

}
