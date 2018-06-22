package com.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
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
				System.out.println("xml ÆÄ½ÌÁß .... ("+(k+1)+"/21)");
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
				
				if(fvo.isChang()){
					
					if(index <10){
						str += index+".-";
					}else{
						str += index+".";
					}
					str += "---------------------------------------------------------------------------------------\n|" + fvo.toString() + " |\n------------------------------------------------------------------------------------------\n";
				}else if ( fvo.isYoung()){
					
					if(index <10){
						str += index+".*";
					}else{
						str += index+".";
					}
					str += "***************************************************************************************\n*" + fvo.toString() + " *\n******************************************************************************************\n";
				}else{
					str += index+"."+fvo.toString() + "\n";
				}
				
				index++;
			}
			
			System.out.println(vo.toString() +"\n"+str);
			
			System.out.println(index+".»óÀ§·Î");
			System.out.println("ÆòÁ¡ ³²±æ ¸Þ´º?");
			
			ch = sc.nextInt();
			
			if( ch >= index || ch<1)
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
	
	public void specialInit(){
		String[] rest = {"ÃßÇ³·É(¼­¿ï)ÈÞ°Ô¼Ò","´öÆòÈÞ°Ô¼Ò", "ÀÌÃµ(Åë¿µ)ÈÞ°Ô¼Ò","Çà´ãµµÈÞ°Ô¼Ò","ÇöÇ³(´ë±¸)ÈÞ°Ô¼Ò","ÇöÇ³(ÇöÇ³)ÈÞ°Ô¼Ò","¼¶Áø°­(ºÎ»ê)ÈÞ°Ô¼Ò" };
		String[] feat = {"-±¹³»ÃÖÃÊÈÞ°Ô¼Ò", "-º°ºûÁ¤¿ø", "-7080" , "-¼¶ ¼ÓÀÇ ½°ÅÍ" , "-µµ±úºñ°ø¿ø", "-500³âµÈ ´ÀÆ¼³ª¹«", "-ÇÇ¾Æ³ë°è´Ü"};
		File[] imgs = {new File("chu.txt"), new File("deok.txt"), new File("icheon.txt"), new File("hangdam.txt"), new File("hdae.txt"), new File("hyunpong.txt"), new File("sumgin.txt")};
		
		for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){
			RestVO vo = it.next();
			
			for(int i=0; i<rest.length; i++){
			
				if( vo.getName().equals(rest[i])){
					
					vo.setFeature(feat[i]);
					vo.setImg(imgs[i]);
					vo.setSpecial(true);
				}
			}
			
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
			System.out.println(index+". »óÀ§·Î");
			ch = sc.nextInt();
			if ( ch >= index || ch <1 )
				return;
			try {
				printThread pt = new printThread(tempList.get(ch-1).getImg());
				pt.start();
				
				pt.join();
				/*FileInputStream fis = new FileInputStream(tempList.get(ch-1).getImg());
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				
				String str ;
				
				while( (str = br.readLine())!= null){
					System.out.println(str);
				}*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void printChang(){
		
		
		
		// iterator »ý¼ºÇÑ´Ù.
		//for¹®À» »ç¿ëÇØ¼­ ÈÞ°Ô¼Ò µéÀ» ÇÏ³ª¾¿ ²¨³½´Ù (¹Ýº¹¹® for, while).
		
		// for È¤Àº while ¾È¿¡¼­ ÈÞ°Ô¼Ò ÇÏ³ª°¡ °¡Áø ¸Þ´ºµéÀ» ÇÏ³ª¾¿ ²¨³»¾î Ã¢·ÄÇÑÁö °Ë»çÇÑ´Ù. (isChang ¸Þ¼Òµå)
		int index = 1;
		for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){

			//ÈÞ°Ô¼Ò¸¦ ²¨³Â´Ù......

			RestVO vo = it.next();

			//¸Þ´ºµéÀ» ÇÏ³ª¾¿ ²¨³½´Ù...Ã¢·ÄÀÌ °Å¸£±â
			
			boolean isPrintRest = false;
			for(Iterator<FoodVO> itf = vo.getFood().iterator(); itf.hasNext();){

				
				FoodVO vof = itf.next();

				if(vof.isChang()){
					if( !isPrintRest){
						System.out.print("\n"+index + ". " +vo.toString()+"\n\n");
						isPrintRest = true;
						index++;
					}
					System.out.println(vof.toString());
				}

			}
			
		}

		
		
	}
	
	public void eyoung(){

		String[] huge ={"¼­¿ï¸¸³²(ºÎ»ê)ÈÞ°Ô¼Ò","°¡Æò(ÃáÃµ)ÈÞ°Ô¼Ò","¸¶Àåº¹ÇÕÈÞ°Ô¼Ò",
				"º¸¼º³ìÂ÷(±¤¾ç)ÈÞ°Ô¼Ò","È¾¼º(°­¸ª)ÈÞ°Ô¼Ò","°­¸ª(°­¸ª)ÈÞ°Ô¼Ò","¼­»ê(¸ñÆ÷)ÈÞ°Ô¼Ò",
				"¾È¼º(ºÎ»ê)ÈÞ°Ô¼Ò","±Ý°­ÈÞ°Ô¼Ò","¸ÁÇâ(ºÎ»ê)ÈÞ°Ô¼Ò"};

		String[] menu ={"¸»Á×°Å¸®¼Ò°í±â±¹¹ä","Àã±¹¼ö","ÀÌÃµ½Ò¹äÁ¤½Ä",
				"²¿¸·ºñºö¹ä","È¾¼ºÇÑ¿ì¶±´õ´ö½ºÅ×ÀÌÅ©","È²ÅÂÇØÀå±¹","¾î¸®±¼Á£¹é¹Ý",
				"¼Ò¶±¼Ò¶±","±Ý°­µµ¸®¹ð¹ðÁ¤½Ä","È£µÎ°úÀÚ"};
		
		if(f.exists()){
			return;
		}
		
		Iterator<RestVO> it = restList.iterator();
		
		while(it.hasNext() ){
			RestVO vo = it.next();
			for(int i=0;i<huge.length;i++){
				if(huge[i].equals(vo.getName())){
					boolean check = false;
					for(int j=0;j<vo.getFood().size() ;j++){
						if(menu[i].equals(vo.getFood().get(j).getName())){
	
							vo.getFood().get(j).setYoung(true);
							check =true;
	
						}
	
					}
					if( !check ){
						FoodVO f = new FoodVO();
						f.setName(menu[i]);
						f.setYoung(true);
						if( menu[i].equals("ÀÌÃµ½Ò¹äÁ¤½Ä")){
							f.setPrice(12000);
						}else if (menu[i].equals("È£µÎ°úÀÚ")){
							f.setPrice(2000);
						}else if (menu[i].equals("¼Ò¶±¼Ò¶±")){
							f.setPrice(3000);
						}else if (menu[i].equals("Àã±¹¼ö")){
							f.setPrice(8000);
						}
						vo.getFood().add(f);
						
					}
	
				}
			}
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
	
	
	public void printTitle(){
		try {
		
			File ff = new File("title.txt");
			
			printThread pt = new printThread(ff);
			pt.start();
			pt.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void printending(){
		try {
			
			File ff = new File("ending.txt");
			
			printThread pt = new printThread(ff);
			pt.start();
			pt.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class printThread extends Thread{
		
		File f;
		
		public printThread(File f){
			
			this.f = f;
			
			
			
			
			
		}
		
		@Override
		public void run() {
			try {
			
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				
				String str;
				
				while( (str = br.readLine() ) != null){
					System.out.println(str);
					
					sleep(100);
				}
				
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
		}
	}
	
}
