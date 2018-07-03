package com.apitest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
			//Socket sock = new Socket("localhost",5555);
		
			List<RestVO> list;
			
			/*ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			
			list = (List<RestVO>) ois.readObject();*/
			
			list = new ArrayList<RestVO>();
			RestVO vo = new RestVO();
			vo.setName("test");
			list.add(vo);
			System.out.println(list.size());
			
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt",true));
			/*oos.writeObject(vo);
			list.get(0).setName("test2");
			vo.setName("test2");
			System.out.println(vo.getName());
			oos.reset();
			oos.writeObject(vo);*/
			
			for(int i=0; i<2; i++){
				oos.writeObject(vo);
				vo.setName("test2");
				oos.reset();
			}
			
			/*for(int i=0; i<2; i++){
				RestVO nvo = new RestVO();
				nvo.setName("test"+i);
				list.set(0,nvo);
				//list.get(0).setName("test"+i);
				System.out.println(list.get(0).getName());
				oos.writeObject(list);
			}*/
			
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));

			RestVO o = (RestVO) ois.readObject();
			RestVO o1 = (RestVO) ois.readObject();
			
			System.out.println(o.toString());
			System.out.println(o1.toString());
			
/*			List<RestVO> l1 = (List<RestVO>) ois.readObject();
			List<RestVO> l2 = (List<RestVO>) ois.readObject();*/
			
//			System.out.println(l1.get(0).getName());
//			System.out.println(l2.get(0).getName());
			//list = (List<RestVO>) ois.readObject();
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
			e.printStackTrace();
		}
	}

}
