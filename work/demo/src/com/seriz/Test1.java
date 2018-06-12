package com.seriz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

/*
 * ��ü�� ����ȭ
 * �޸𸮿� ������ Ŭ���� ��ü�� ��� ������ ������¸�
 * �״�� �����ؼ� ���Ͽ� �����ϰų� ��Ʈ��ũ�� ���� 
 * ���� �� �� �ִ� ���
 * ������ ����Ʈ �����θ� �����͸� �ۼ��� �� �� �ִ�
 * 
 * ����: ��ü ��ü�� �����͸� ����� ���Ŀ� ���ֹ��� �ʰ�
 * ��ü�� ���Ͽ� ���� �����ν� ���Ӽ��� ���� �� �� �ְ�
 * ��ü ��ü�� ��Ʈ��ũ�� ���� �ս��� ��ȯ �� �� �ִ�.
 * 
 * implements Serializable�� ���� �Ѵ�. ( �� �޼ҵ�� ����)
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
