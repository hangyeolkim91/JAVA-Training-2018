package com.collections;

import java.util.Vector;

class Test{
	
	String name;
	int age;
}

public class Test1 {

	public static void main(String[] args) {

		Vector<Test> v = new Vector<Test>();
		
		Test ob = new Test();
		ob.name = "�����";
		ob.age = 25;
		v.add(ob);
		

		ob = new Test();
		ob.name="�ڽ���";
		ob.age=28;
		v.add(ob);
		for( Test t : v){
			System.out.println(t.name);
			System.out.println(t.age);
		}
	}

}
