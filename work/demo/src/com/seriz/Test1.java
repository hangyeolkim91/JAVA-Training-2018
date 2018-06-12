package com.seriz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

/*
 * 객체의 직렬화
 * 메모리에 생성된 클래스 객체의 멤버 변수의 현재상태를
 * 그대로 보존해서 파일에 저장하거나 네트워크를 통해 
 * 전달 할 수 있는 기능
 * 오로지 바이트 단위로만 데이터를 송수신 할 수 있다
 * 
 * 장점: 객체 자체의 데이터를 입출력 형식에 구애받지 않고
 * 객체를 파일에 저장 함으로써 영속성을 제공 할 수 있고
 * 객체 자체를 네트워크를 통해 손쉽게 교환 할 수 있다.
 * 
 * implements Serializable로 구현 한다. ( 단 메소드는 없다)
 * 
 */

public class Test1 {

	public static void main(String[] args) {
		
		Hashtable<String, String> hMap = new Hashtable<String, String>();
		
		hMap.put("1", "abc");
		hMap.put("2", "def");
		hMap.put("3", "ghi");
		hMap.put("4", "jkl");
		
		try {
			FileOutputStream fos = new FileOutputStream("d:/doc/a1.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(hMap);
			
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
