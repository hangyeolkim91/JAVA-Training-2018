package com.swing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("클래스 명[예: java.lang.String] : ");
		String str;
		try {
			str = br.readLine();
			Class cls = Class.forName(str);
			
			Constructor<?>[] c = cls.getConstructors();
			System.out.println("생성자...");
			
			for(int i=0; i<c.length; i++){
				System.out.println(c[i]);
			}
			
			Field[] fd = cls.getFields();
			
			System.out.println("Fields....");
			for(Field f : fd)
				System.out.println(f);
			
			System.out.println("Methods.....");
			
			Method[] mtd = cls.getMethods();
			
			for( Method m : mtd)
				System.out.println(m);
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
