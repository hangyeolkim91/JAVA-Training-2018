package com.seriz;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyDataMain {

	public static void main(String[] args) {
		
		try {
			//직렬화
			FileOutputStream fos = new FileOutputStream("d:/doc/a2.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new MyData("abc",19));
			oos.writeObject(new MyData("def",50));
			oos.writeObject(new MyData("ghi",90));
			oos.writeObject(new MyData("jkl",30));
			oos.writeObject(new MyData("mno",50));
			
			oos.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			//역직렬화
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/doc/a2.txt"));
			
			
/*			MyData[] md = new MyData[5];
			for( int i = 0; i<5; i++){
				md[i] = (MyData) ois.readObject();
			}
			for(int i=0; i<md.length; i++){
				System.out.println(md[i].toString());
			}*/
			MyData md;
			while( (md = (MyData)ois.readObject()) != null ){
				System.out.println(md.toString());
			}
			
			ois.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
