package com.stream1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


/*
 * RandomAccessFile
 * �Ϲ����� ������ ���������� data�� �о��
 * RandomAccessFile�� ���ϴ� ������ �̵��ؼ� �д°� ����
 * 
 */


public class Test1 {

	public static void main(String[] args) {

		try {
			File f = File.createTempFile("temp", ".tmp");
			f.deleteOnExit();
			
			FileOutputStream fos = new FileOutputStream(f);
			
			for(int i=0; i<100; i++){
				fos.write(i);
			}
			
			fos.close();
			
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			raf.seek(30);
			System.out.println("seek(30): "+raf.readByte());
			raf.seek(1);
			System.out.println("seek(1): " + raf.readByte());
			
			for(int i=0; i<100; i++){
				raf.seek(i);
				System.out.println(raf.readByte());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
