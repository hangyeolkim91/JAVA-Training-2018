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
 * Serializable �������̽��� ���� �������̽�
 * Serializable�� ���� ����� �ϵ� �� �� �Ϻ��� ��� ������
 * writeExternal(), readExternal()�޼ҵ带 ����
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
	@Override  // ���� ȣ�� �� ������ȭ
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = (String)in.readObject();
		age = in.readInt();
		
		System.out.println("readExternal()..");
	}

	@Override // ����ȭ�� ȣ��
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
