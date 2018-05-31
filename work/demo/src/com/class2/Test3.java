package com.class2;

import java.util.Calendar;

public class Test3 {

	public static void main(String[] args) {

//		CustomInfo ob = new CustomInfo();
//		ob.Info();
		CustomInfo.getInfo(); //static ¿Ã∂Ûº≠ get
		
		Calendar ob1 = Calendar.getInstance();
		Calendar ob2 = Calendar.getInstance();
		Calendar ob3 = Calendar.getInstance();
		
		System.out.println(ob1==ob2);
		
		System.out.println(ob1.getTime());
		System.out.println(ob2.getTime());
	}

}
