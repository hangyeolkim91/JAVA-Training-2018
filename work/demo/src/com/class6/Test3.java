package com.class6;

/*
 *  Interface
 *  1. 추상 클래스의 일종 선언만 있고 정의(내용)이 없다.
 *  2. final변수만 정의 할 수 있다.
 *  3. 인터페이스를 구현하기 위해서는 implements를 사용한다.
 *  4. 하나이상의 인터페이스를 구현 한 클래스는 인터페이스의 
 *  모든 메소드를 구현(override)해야 한다.
 *  5. 인터페이스가 인터페이스를 상속 받을 수 있으며 이때 extends
 *  키워드를 사용한다.
 *  6. 인터페이스는 다중 상속이 가능하다.
 *  7. 인터페이스는 저장소이다.
 *  8. 강제적용이 가능하다.
 */

interface Fruit{
	
	String Won = "원"; // public static final이 생략 (상수)
	
	int getPrice();    // public abstract 생략 
	
	public String getName();
}

class FruitImpl implements Fruit{

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "사과";
	}
	
	public String getItems(){
		return "과일";
	}
	
	
}

class BananaFruitImpl implements Fruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "banana";
	}
	
	public String getItems(){
		return "과일";
	}
	
}

public class Test3 {

	public static void main(String[] args) {

		FruitImpl ob = new FruitImpl();
		
		//System.out.println(ob.getItems() + " : " + ob.getName() + " : " + ob.getPrice() + Fruit.Won);
		
		//Fruit ob2 = new FruitImpl();
		
		Fruit[] ob2 = { new FruitImpl(), new BananaFruitImpl() };
		
		//System.out.println(ob2.getItems());
		
		//System.out.println(((FruitImpl) ob2).getItems());
		
		for(Fruit f : ob2){
			System.out.println( f.getName() + " : " + f.getPrice() + Fruit.Won);
		}
		//System.out.println(((FruitImpl) ob2).getItems() + " : " + ob2.getName() + " : " + ob2.getPrice() + Fruit.Won);
	}

}
