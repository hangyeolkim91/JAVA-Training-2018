package com.seriz;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 * Externalizable
 * Serializable 인터페이스의 하위 인터페이스
 * Serializable과 같은 기능을 하되 좀 더 완벽한 제어가 가능함
 * writeExternal(), readExternal()메소드를 정의
 */

class DataTest implements Externalizable{

	private String name;
	private int age;
	
	public DataTest() {
		// TODO Auto-generated constructor stub
	}
	
		
	public DataTest(String name, int age) {
		this.name = name;
		this.age = age;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
	@Override  // 복원 호출 시 역직렬화
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = (String)in.readObject();
		age = in.readInt();
		
		System.out.println("readExternal()..");
	}

	@Override // 직렬화시 호출
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		
		System.out.println("writeExternal()..");
	}
	
}
public class Test3 {

	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("d:/doc/a3.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new DataTest("aaa", 14));
			
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/doc/a3.txt"));
			
			DataTest dt = (DataTest)ois.readObject();
			
			System.out.println(dt.toString());
			ois.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
