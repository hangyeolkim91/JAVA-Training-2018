package com.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RestServer {

	private List<RestVO> restList;
	private File f = new File("restList.txt");
	private Scanner sc = new Scanner(System.in);
	private ServerSocket serverSock;
	private ExecutorService threadPool = Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors());
	private List<Client> connections = new Vector<RestServer.Client>();
	

	
	class Client{
		Socket sock;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		public Client(Socket sock){
			this.sock = sock;
			try {
				ois = new ObjectInputStream(sock.getInputStream());
				oos = new ObjectOutputStream(sock.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			receive();
			
		}
		
		public void receive(){
			
			try {
				
				
				
				while(true){
					

					String cmd = (String)ois.readObject();
					System.out.println("cmd: " + cmd);
					
					if( cmd.substring(0,2).equals("se")){
						cmd = cmd.substring(2);
						int idx = Integer.parseInt(cmd);
						List<RestVO> tlist = search(idx);
						
						System.out.println("∫∏≥ª¥¬ ∞≈");
						
						for(Iterator<RestVO> it = tlist.iterator(); it.hasNext();){
							RestVO rvo = it.next();
							System.out.println(rvo.toString());
							System.out.println(rvo.getFood().get(0).toString());
						}
						oos.writeObject(tlist);
						oos.flush();

					}else if ( cmd.substring(0,2).equals("ra")){
						System.out.println("raaaaaaaa");
						RestVO searchRestvo = (RestVO) ois.readObject();
						System.out.println(searchRestvo.toString());
						for(Iterator<FoodVO> it = searchRestvo.getFood().iterator(); it.hasNext();){
							FoodVO fvo = it.next();
							System.out.println(fvo.toString());
						}
						System.out.println();
						int idx=0;
						for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){
							RestVO findRestvo = it.next();
							
							if( findRestvo.getName().equals(searchRestvo.getName())){
								System.out.println("change");
								
								//idx = restList.indexOf(findRestvo);
								findRestvo.setFood(searchRestvo.getFood());
								
								
							}
						}
						
						for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){
							RestVO findRestvo = it.next();
							
							if( findRestvo.getName().equals("≥≤º∫¡÷(«ˆ«≥)»ﬁ∞‘º“")){
								System.out.println("changed");
								
								//idx = restList.indexOf(findRestvo);
								for(Iterator<FoodVO> itf = findRestvo.getFood().iterator(); itf.hasNext();){
								
									FoodVO fvo = itf.next();
									System.out.println(fvo.toString());
								}
								
								
								
							}
						}
						
					}
					
					
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
/*			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					
					try {
						
						
						
						while(true){
							

							String cmd = (String)ois.readObject();
							System.out.println("cmd: " + cmd);
							
							if( cmd.substring(0,2).equals("se")){
								cmd = cmd.substring(2);
								int idx = Integer.parseInt(cmd);
								List<RestVO> tlist = search(idx);
								
								System.out.println("∫∏≥ª¥¬ ∞≈");
								
								for(Iterator<RestVO> it = tlist.iterator(); it.hasNext();){
									RestVO rvo = it.next();
									System.out.println(rvo.toString());
									System.out.println(rvo.getFood().get(0).toString());
								}
								oos.writeObject(tlist);
								oos.flush();

							}else if ( cmd.substring(0,2).equals("ra")){
								System.out.println("raaaaaaaa");
								RestVO searchRestvo = (RestVO) ois.readObject();
								System.out.println(searchRestvo.toString());
								for(Iterator<FoodVO> it = searchRestvo.getFood().iterator(); it.hasNext();){
									FoodVO fvo = it.next();
									System.out.println(fvo.toString());
								}
								System.out.println();
								int idx=0;
								for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){
									RestVO findRestvo = it.next();
									
									if( findRestvo.getName().equals(searchRestvo.getName())){
										System.out.println("change");
										
										//idx = restList.indexOf(findRestvo);
										findRestvo.setFood(searchRestvo.getFood());
										
										
									}
								}
								
								for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){
									RestVO findRestvo = it.next();
									
									if( findRestvo.getName().equals("≥≤º∫¡÷(«ˆ«≥)»ﬁ∞‘º“")){
										System.out.println("changed");
										
										//idx = restList.indexOf(findRestvo);
										for(Iterator<FoodVO> itf = findRestvo.getFood().iterator(); itf.hasNext();){
										
											FoodVO fvo = itf.next();
											System.out.println(fvo.toString());
										}
										
										
										
									}
								}
								
								restList.remove(idx);
								restList.add(searchRestvo);
								
							}
							
							
							
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			};
			threadPool.submit(runnable);*/
			
		}
	}
	
	public static void main(String[] agrs){
		
		RestServer rs = new RestServer();
		
		rs.getXml();
		rs.startServer();
		
		
		
	}
	
	public RestServer(){
		try {
			
			serverSock = new ServerSocket(5555);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void startServer(){
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Socket sock = serverSock.accept();
						System.out.println(sock.getInetAddress().getAddress()+"¡¢º”");
						Client c = new Client(sock);
						
						connections.add(c);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}
		};
		threadPool.submit(runnable);
		
	}
	
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
				System.out.println("xml ∆ƒΩÃ¡ﬂ .... ("+(k+1)+"/21)");
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
					throw new Exception("º≠πˆ¿¿¥‰ø°∑Ø");
				
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
	
	public List<RestVO> search(int idx){
		String[] reg={"[∞°-Éâ]+.*","[≥™-à¢]+.*","[¥Ÿ-ãL]+.*","[∂Û-ê°]+.*","[∏∂-ìJ]+.*","[πŸ-ïΩ]+.*","[ªÁ-öÔ]+.*","[æ∆-üÁ]+.*",
				"[¿⁄-£†]+.*","[¬˜-ØÜ]+.*","[ƒ´-µi]+.*","[≈∏-ªM]+.*","[∆ƒ-¿ò]+.*","[«œ-∆R]+.*"};
		
		Pattern p = Pattern.compile(reg[idx-1]);
		
		List<RestVO> tempList = new ArrayList<RestVO>();
		for(Iterator<RestVO> it = restList.iterator() ; it.hasNext();){
			RestVO vo = it.next();
			Matcher m = p.matcher(vo.getName());
			
			if(m.matches()){
				tempList.add(vo);
			}
		}
		return tempList;
		
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
			
			System.out.println(index+".ªÛ¿ß∑Œ");
			System.out.println("∆Ú¡° ≥≤±Ê ∏ﬁ¥∫?");
			
			ch = sc.nextInt();
			
			if( ch == index)
				return;
			System.out.println("∆Ú¡°? (0~5.0)");
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
		String[] rest = {"√ﬂ«≥∑…(º≠øÔ)»ﬁ∞‘º“","¥ˆ∆Ú»ﬁ∞‘º“", "¿Ã√µ(≈Îøµ)»ﬁ∞‘º“","«‡¥„µµ»ﬁ∞‘º“","«ˆ«≥(¥Î±∏)»ﬁ∞‘º“","«ˆ«≥(«ˆ«≥)»ﬁ∞‘º“","º∂¡¯∞≠(∫ŒªÍ)»ﬁ∞‘º“" };
		String[] feat = {"-±π≥ª√÷√ »ﬁ∞‘º“", "-∫∞∫˚¡§ø¯", "-7080" , "-º∂ º”¿« Ω∞≈Õ" , "-µµ±˙∫Ò∞¯ø¯", "-500≥‚µ» ¥¿∆º≥™π´", "-««æ∆≥Î∞Ë¥‹"};
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
			System.out.println(index+". ªÛ¿ß∑Œ");
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
		
		
		
		// iterator ª˝º∫«—¥Ÿ.
		//forπÆ¿ª ªÁøÎ«ÿº≠ »ﬁ∞‘º“ µÈ¿ª «œ≥™æø ≤®≥Ω¥Ÿ (π›∫ππÆ for, while).
		
		// for »§¿∫ while æ»ø°º≠ »ﬁ∞‘º“ «œ≥™∞° ∞°¡¯ ∏ﬁ¥∫µÈ¿ª «œ≥™æø ≤®≥ªæÓ √¢∑ƒ«—¡ˆ ∞ÀªÁ«—¥Ÿ. (isChang ∏ﬁº“µÂ)
		for(Iterator<RestVO> it = restList.iterator(); it.hasNext();){

			//»ﬁ∞‘º“∏¶ ≤®≥¬¥Ÿ......

			RestVO vo = it.next();

			//∏ﬁ¥∫µÈ¿ª «œ≥™æø ≤®≥Ω¥Ÿ...√¢∑ƒ¿Ã ∞≈∏£±‚

			for(Iterator<FoodVO> itf = vo.getFood().iterator(); itf.hasNext();){

				FoodVO vof = itf.next();

				if(vof.isChang()){
					System.out.println(vo.getName() + "\n" + vof);
				}

			}
			System.out.println();
		}

		
		
	}
	
	public void eyoung(){

		String[] huge ={"º≠øÔ∏∏≥≤(∫ŒªÍ)»ﬁ∞‘º“","∞°∆Ú(√·√µ)»ﬁ∞‘º“","∏∂¿Â∫π«’»ﬁ∞‘º“",
				"∫∏º∫≥Ï¬˜(±§æÁ)»ﬁ∞‘º“","»æº∫(∞≠∏™)»ﬁ∞‘º“","∞≠∏™(∞≠∏™)»ﬁ∞‘º“","º≠ªÍ(∏Ò∆˜)»ﬁ∞‘º“",
				"æ»º∫(∫ŒªÍ)»ﬁ∞‘º“","±›∞≠»ﬁ∞‘º“","∏¡«‚(∫ŒªÍ)»ﬁ∞‘º“"};

		String[] menu ={"∏ª¡◊∞≈∏Æº“∞Ì±‚±ππ‰","¿„±πºˆ","¿Ã√µΩ“π‰¡§Ωƒ",
				"≤ø∏∑∫Ò∫ˆπ‰","»æº∫«—øÏ∂±¥ı¥ˆΩ∫≈◊¿Ã≈©","»≤≈¬«ÿ¿Â±π","æÓ∏Æ±º¡£πÈπ›",
				"º“∂±º“∂±","±›∞≠µµ∏Æππ¡§Ωƒ","»£µŒ∞˙¿⁄"};
		
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
	
	
	
}
