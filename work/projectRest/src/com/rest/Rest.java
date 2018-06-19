package com.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class Rest {

	private List<RestVO> restList;
	private File f = new File("restList.txt");
	private Scanner sc = new Scanner(System.in);
	
	public void getXml(){
		
		if(!f.exists()){
			restList = new Vector<RestVO>();
		}else{
			readFile();
			return;
		}
		
		try {
			
			int sum = 0;
			

			String url = null;
			for(int k=0; k<21; k++){
				
				int nn = 0;
				url = "http://data.ex.co.kr/exopenapi/restinfo/restBestfoodList?type=xml&numOfRows=100&ServiceKey=fw1H1W6zTKz61F2a41o%2BpXHwFh22RwDbTp0CXJxq47VGp22CD1HjLi2ovm7ENhDZvNffrQhlCVWeqQrSWDp5Kw%3D%3D&pageNo=";
				url += (k+1);
				
				DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
				
				DocumentBuilder parser = f.newDocumentBuilder();
				
				Document xmlDoc = null;
				
				//URL u = new URL(url);
				//InputStream is = u.openStream();
				
				xmlDoc = parser.parse(url);
					
	

				
				String str="";
				
				Element root = xmlDoc.getDocumentElement();
	
				Node code = root.getElementsByTagName("code").item(0);
				
				str = code.getFirstChild().getNodeValue();
				
				//System.out.println("response code : " + str);
				
				if( !str.equals("00"))
					throw new Exception("¼­¹öÀÀ´ä¿¡·¯");
				
				NodeList items = root.getElementsByTagName("list");
				
				
	
				RestVO rvo = null;
				
				for(int i=0; i<items.getLength(); i++){
					
					
					Node node = items.item(i);
					
					NodeList nodeList = node.getChildNodes();
					FoodVO fvo = new FoodVO();
					for(int j=0; j<nodeList.getLength(); j++){
						Node e = nodeList.item(j);
						
						
						
						String value=e.getChildNodes().item(0).getNodeValue().replaceAll("\\s", "");
						
						if(e.getNodeName().equals("stdRestNm")){
							
							
							
							if(restList.size() == 0){
								rvo = new RestVO();
								
								rvo.setName(value);
								
								restList.add(rvo);
								restList.get(restList.size()-1).getFood().add(fvo);

							}else if ( restList.get(restList.size()-1).getName().equals(value)){
								
								restList.get(restList.size()-1).getFood().add(fvo);
								
							}else if(!restList.get(restList.size()-1).getName().equals(value)){

								rvo = new RestVO();
								
								rvo.setName(value);
								rvo.getFood().add(fvo);
								restList.add(rvo);
								
							}
				
						}else if ( e.getNodeName().equals("foodNm")){

							 
							fvo.setName(value);
						}else if (e.getNodeName().equals("foodCost")){
							 
							fvo.setPrice(Integer.parseInt(value));
						}else if (e.getNodeName().equals("seasonMenu")){
							
							fvo.setSeason(value);
						}
						
					}

					
				}

				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void search(int idx){
		String[] reg={"[°¡-ƒ‰]+.*","[³ª-ˆ¢]+.*","[´Ù-‹L]+.*","[¶ó-¡]+.*","[¸¶-“J]+.*","[¹Ù-•½]+.*","[»ç-šï]+.*","[¾Æ-Ÿç]+.*",
				"[ÀÚ-£ ]+.*","[Â÷-¯†]+.*","[Ä«-µi]+.*","[Å¸-»M]+.*","[ÆÄ-À˜]+.*","[ÇÏ-ÆR]+.*"};
		
		Pattern p = Pattern.compile(reg[idx-1]);
		
		List<RestVO> tempList = new Vector<RestVO>();
		for(Iterator<RestVO> it = restList.iterator() ; it.hasNext();){
			RestVO vo = it.next();
			Matcher m = p.matcher(vo.getName());
			
			if(m.matches()){
				tempList.add(vo);
			}
		}

		int ch;
		while(true){
			int index = 1;
			for(Iterator<RestVO> it = tempList.iterator(); it.hasNext();){
				
				RestVO vo = it.next();
				System.out.println(index+"."+vo.toString());
				index++;
			}
			System.out.println(index+".»óÀ§·Î");
			System.out.println("¼±ÅÃ?");
			ch = sc.nextInt();
			if( ch >= index || ch<1)
				return;
			print(tempList.get(ch-1));
			
		}
		
	}
	
	public void readFile(){
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			
			restList = (Vector<RestVO>) ois.readObject();
			
			ois.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void writeFile(){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			
			oos.writeObject(restList);
			
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void print(){
		
		
		for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){
			RestVO vo = it.next();
			
			String str = "";
			for(Iterator<FoodVO> itf = vo.getFood().iterator(); itf.hasNext();){
				FoodVO fvo = itf.next();
				
				str += fvo.toString() + "\n";
			}
			
			System.out.println(vo.toString() +"\n--------------------------------------\n"+str);
		}
		
		
	}
	
	public void print(RestVO vo){
		
		

		while(true){
			String str = "";
			int index = 1;
			int ch;
			for(Iterator<FoodVO> itf = vo.getFood().iterator(); itf.hasNext();){
				FoodVO fvo = itf.next();
				
				str += index+"."+fvo.toString() + "\n";
				index++;
			}
			
			System.out.println(vo.toString() +"\n--------------------------------------\n"+str);
			System.out.println(index+".»óÀ§·Î");
			System.out.println("ÆòÁ¡ ³²±æ ¸Þ´º?");
			
			ch = sc.nextInt();
			
			if( ch == index)
				return;
			System.out.println("ÆòÁ¡? (0~5.0)");
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

		}
		
		
		
	}
	
}
