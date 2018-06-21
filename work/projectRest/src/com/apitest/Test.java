package com.apitest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rest.FoodVO;
import com.rest.RestVO;

public class Test  {

	private List<RestVO> list;
	RestVO vo;
	private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public Test(){

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restList.txt"));

			list = (List<RestVO>)ois.readObject();

			ois.close();


		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public static void main(String[] args) {

		Test t = new Test();

		try {

			ServerSocket serverSock = new ServerSocket(5555);
			Socket sock = serverSock.accept();

			System.out.println(sock.getInetAddress().getHostAddress()+"접속");

			System.out.println("받기전 크기 " + t.list.size());
			/*ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			oos.writeObject(t.list);*/

			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			t.list = (List<RestVO>)ois.readObject();
			System.out.println("받은 크기" + t.list.size());
			for(Iterator<RestVO> it = t.list.iterator(); it.hasNext();){

				RestVO vo = it.next();
				System.out.println(vo.toString());
				System.out.println("전송끝");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
