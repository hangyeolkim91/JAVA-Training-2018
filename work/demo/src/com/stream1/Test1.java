package com.stream1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


/*
 * RandomAccessFile
 * 일반적인 파일은 순차적으로 data를 읽어옴
 * RandomAccessFile은 원하는 곳으로 이동해서 읽는게 가능
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
