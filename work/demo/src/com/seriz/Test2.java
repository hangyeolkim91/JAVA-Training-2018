package com.seriz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;



public class Test2 {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("d:/doc/a1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			Hashtable<String, String> hMap = (Hashtable<String, String>) ois.readObject();
			
			Iterator<String> it = hMap.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				String value = hMap.get(key);
				System.out.println(key+ " " + value);
			}
			
			ois.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
