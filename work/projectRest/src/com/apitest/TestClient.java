package com.apitest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rest.RestVO;

public class TestClient {

	public static void main(String[] args) {

		try {
			Socket sock = new Socket("localhost",5555);
		
			List<RestVO> list;
			
			/*ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			
			list = (List<RestVO>) ois.readObject();*/
			
			list = new ArrayList<RestVO>();
			RestVO vo = new RestVO();
			vo.setName("test");
			list.add(vo);
			System.out.println(list.size());
			
			
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			oos.writeObject(list);
			/*for(Iterator<RestVO> it = list.iterator(); it.hasNext();){
				
				RestVO vo = it.next();
				
				if(vo.isSpecial()){
					FileInputStream fis = new FileInputStream(vo.getImg());
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
					
					String str;
					while ((str = br.readLine()) != null){
						System.out.println(str);
					}
					
				}
			}*/
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
