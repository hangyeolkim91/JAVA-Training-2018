package com.rest;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RestClient {

	private List<RestVO> restList;
	private Scanner sc = new Scanner(System.in);
	private Socket sock;
	private String host = "localhost";
	private int port = 5555;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public RestClient(){

		try {
			sock = new Socket(host,port);
			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		RestClient rc = new RestClient();

		int ch;
		while(true){

			do{
				System.out.println("1.�ްԼҰ˻� 2.�̿��ڸ���Ʈ 3.â�ĸ���Ʈ 4.�̻��ްԼ� 5.����");
				ch = sc.nextInt();
			}while(ch <1 || ch>10);


			if(ch ==1 ){
				System.out.println("1.�� 2.�� 3.�� 4.�� 5.�� 6.�� 7.�� 8.�� 9.�� 10.�� 11.�� 12.�� 13.�� 14.��");
				ch = sc.nextInt();

				rc.search(ch);
			}else if ( ch ==2 ){
				rc.eyounprint();
			}else if ( ch == 3){
				rc.printChang();
			}else if ( ch==4){
				rc.printSpecial();

			}else if ( ch == 5){

				System.exit(0);
			}
		}

	}


	public void search(int idx){


		try {
			int ch;
			
			while(true){
				

					//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

					String msg = "se";
					msg += idx;
					//System.out.println(msg);
					oos.writeObject(msg);
					oos.flush();
					
					
					
					List<RestVO> tempList =null;
					tempList = (List<RestVO>) ois.readObject();
					
					System.out.println("������:");
					int index = 1;
					for(Iterator<RestVO> it = tempList.iterator(); it.hasNext();){

						RestVO vo = it.next();
						System.out.println(index+"."+vo.toString());
						System.out.println(vo.getFood().get(0));
						index++;
					}
					System.out.println(index+".������");
					System.out.println("����?");
					ch = sc.nextInt();
					if( ch >= index || ch<1)
						return;
					print(tempList.get(ch-1));


			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}


	public void print(RestVO vo){

		try {
			
			
			while(true){
				
				String str = "";
				int index = 1;
				int ch;
				for(Iterator<FoodVO> itf = vo.getFood().iterator(); itf.hasNext();){
					FoodVO fvo = itf.next();

					if(fvo.isChang()){

						if(index <10){
							str += index+".-";
						}else{
							str += index+".";
						}
						str += "------------------------------------------------------------------------------------------\n|" + fvo.toString() + "      |\n---------------------------------------------------------------------------------------------\n";
					}else if ( fvo.isYoung()){

						if(index <10){
							str += index+".*";
						}else{
							str += index+".";
						}
						str += "***************************************************************************************\n*" + fvo.toString() + "   *\n******************************************************************************************\n";
					}else{
						str += index+"."+fvo.toString() + "\n";
					}

					index++;
				}

				System.out.println(vo.toString() +"\n"+str);

				System.out.println(index+".������");
				System.out.println("���� ���� �޴�?");

				ch = sc.nextInt();

				if( ch >= index || ch <1)
					return;
				System.out.println("����? (0~5.0)");
				double rat = sc.nextDouble();

				int i = ch-1;
				double oldRating = vo.getFood().get(i).getRating();
				double oldTotal = vo.getFood().get(i).getTotal();
				int oldCount = vo.getFood().get(i).getCount();

				double newTotal = oldTotal + rat;
				int newCount = oldCount +1;
				double newRating = newTotal/newCount;

				vo.getFood().get(i).setTotal(newTotal);
				vo.getFood().get(i).setCount(newCount);
				vo.getFood().get(i).setRating(newRating);
				if(newRating >4.5){
					vo.getFood().get(i).setYoung(true);
				}else if (  newRating <=4.5){
					vo.getFood().get(i).setYoung(false);
				}

				if(newRating <2.0){
					vo.getFood().get(i).setChang(true);
				}else if ( newRating >= 2.0){
					vo.getFood().get(i).setChang(false);
				}
				
				String cmd = "ra";
				oos.writeObject(cmd);
				oos.flush();
				System.out.println("ra ������ �� " + vo.getFood().get(i).getRating());
				oos.writeObject(vo);
				oos.flush();

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		



	}


	public void printSpecial(){

		List<RestVO> tempList = new Vector<RestVO>();
		for(Iterator<RestVO> it = restList.iterator() ; it.hasNext();){
			RestVO vo = it.next();

			if( vo.isSpecial()){
				tempList.add(vo);

			}
		}

		while(true){
			int index = 1;

			for(Iterator<RestVO> it = tempList.iterator(); it.hasNext();){
				RestVO vo = it.next();
				System.out.println(index+". "+vo.toString() + vo.getFeature());
				index++;
			}
			int ch;
			System.out.println(index+". ������");
			ch = sc.nextInt();
			if ( ch == index )
				return;
			try {
				FileInputStream fis = new FileInputStream(tempList.get(ch-1).getImg());
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));

				String str ;

				while( (str = br.readLine())!= null){
					System.out.println(str);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}

	public void printChang(){



		// iterator �����Ѵ�.
		//for���� ����ؼ� �ްԼ� ���� �ϳ��� ������ (�ݺ��� for, while).

		// for Ȥ�� while �ȿ��� �ްԼ� �ϳ��� ���� �޴����� �ϳ��� ������ â������ �˻��Ѵ�. (isChang �޼ҵ�)
		for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){

			//�ްԼҸ� ���´�......

			RestVO vo = it.next();

			//�޴����� �ϳ��� ������...â���� �Ÿ���

			for(Iterator<FoodVO> itf = vo.getFood().iterator(); itf.hasNext();){

				FoodVO vof = itf.next();

				if(vof.isChang()){
					System.out.println(vo.getName() + "\n" + vof);
				}

			}
			System.out.println();
		}



	}


	public void eyounprint(){
		Iterator<RestVO> it = restList.iterator();

		int index =1;

		while(it.hasNext()){
			RestVO vo = it.next();

			Iterator<FoodVO> itf = vo.getFood().iterator();

			boolean isPrintRest = false;

			while(itf.hasNext()){
				FoodVO fvo = itf.next();

				if( fvo.isYoung() ){
					if( !isPrintRest){
						System.out.print("\n"+index + ". " +vo.toString()+"\n\n");
						isPrintRest = true;
						index++;
					}
					System.out.println(  fvo.toString());

				}
			}

		}
	}



}
