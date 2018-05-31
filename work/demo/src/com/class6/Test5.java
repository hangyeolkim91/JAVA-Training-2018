package com.class6;

import java.util.Scanner;

interface FruitA{
	
	String Won = "원";
	
	public  int getPrice();
	public String getName();
}

interface ItemFruit extends FruitA{
	
	public String getItems();
}

class Orange implements ItemFruit{

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "오렌지";
	}

	@Override
	public String getItems() {
		return "과일";
	}
	
}

class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "사과";
	}

	@Override
	public String getItems() {
		return "과일";
	}
	
	
}

public class Test5 {
	
	public void packing(ItemFruit ob){
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Test5 t = new Test5();
		
		System.out.println("1. 오렌지 2.사과 ?");
		int n = sc.nextInt();
		
		if( n == 1){
			
			t.packing(new Orange());
			
		}else{
			
			t.packing(new Apple());
			
		}
				
		
		//----------------------------------------------------------
		/*ItemFruit[] fa = {ob1, ob2};
		
		for( ItemFruit f : fa){
			System.out.println(f.getItems() + " " + f.getName() + " " + f.getPrice() + FruitA.Won);
		}*/
	}

}
