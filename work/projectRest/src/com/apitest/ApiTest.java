package com.apitest;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;






import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApiTest {

	public static void main(String[] args) {

		try {
			
			
			
			String serviceKey = "fw1H1W6zTKz61F2a41o%2BpXHwFh22RwDbTp0CXJxq47VGp22CD1HjLi2ovm7ENhDZvNffrQhlCVWeqQrSWDp5Kw%3D%3D";
			String url = "http://data.ex.co.kr/exopenapi/restinfo/restBestfoodList?type=xml&ServiceKey=";
			
			String pageNo = "&pageNo=";
			String numOfRows ="&numOfRows=99";
			url+=serviceKey+numOfRows+pageNo;
			int sum = 0;
			
			Set<String> set = new HashSet<String>();
			List<String> list = new ArrayList<String>();
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
					
	
				//is.close();
				
				String str="";
				
				Element root = xmlDoc.getDocumentElement();
	
				Node code = root.getElementsByTagName("code").item(0);
				
				str = code.getFirstChild().getNodeValue();
				
				System.out.println("response code : " + str);
				
				NodeList items = root.getElementsByTagName("list");
				
				
				String restName=null;
				int count = 0;
				
				for(int i=0; i<items.getLength(); i++){
					
					
					Node node = items.item(i);
					
					NodeList nodeList = node.getChildNodes();
					//System.out.println(nodeList.getLength());
					for(int j=0; j<nodeList.getLength(); j++){
						Node e = nodeList.item(j);
						
						
						
						
						if(e.getNodeName().equals("stdRestNm")){
							//System.out.println("stdRestNm");
							count++;
							
							if(restName == null){
								restName = e.getChildNodes().item(0).getNodeValue().replaceAll("\\s", "");
								set.add(restName);
								
							}else if(!restName.equals(e.getChildNodes().item(0).getNodeValue().replaceAll("\\s", ""))){
								//System.out.println(restName +" : " +  ( count -1));
								set.add(restName);
								sum +=(count-1);
								nn+=(count-1);
								restName = e.getChildNodes().item(0).getNodeValue().replaceAll("\\s", "");
								//System.out.println(count-1);
								count = 1;
								
							}
							//str += e.getChildNodes().item(0).getNodeValue().replaceAll("\\s", "");						
						}else if ( e.getNodeName().equals("foodNm")){
							//System.out.println("foodNm");
							str = e.getChildNodes().item(0).getNodeValue().replaceAll("\\s", "");
							list.add(str);
							//count++;
						}
						
					}
	/*				System.out.println(str);
					str="";*/
					
				}
				//System.out.println(restName+" : " + count);
				nn +=(count);
				//System.out.println("nn : " + nn);
				sum+=count;
				set.add(restName);
				
			}
			
			System.out.println("ÃÑ ¸Ş´º ¼ö : "+ sum);
			System.out.println("ÃÑ ÈŞ°Ô¼Ò ¼ö : " + set.size());
			System.out.println(list.size());
			

			
/*			List<String> list = new ArrayList<String>();
			list.addAll(set);
			list.sort(null);
			Iterator<String> it = list.iterator();*/
			
			//String[] reg={"[°¡-ƒ‰]+.*","[³ª-ˆ¢]+.*","[´Ù-‹L]+.*","[¶ó-¡]+.*","[¸¶-“J]+.*","[¹Ù-•½]+.*","[»ç-šï]+.*","[¾Æ-Ÿç]+.*",
			//		"[ÀÚ-£ ]+.*","[Â÷-¯†]+.*","[Ä«-µi]+.*","[Å¸-»M]+.*","[ÆÄ-À˜]+.*","[ÇÏ-ÆR]+.*"};
			
			
/*			int s =0;
			int ss = 0;
			for(int l=0; l<reg.length; l++){
				s=0;
				System.out.println(reg[l]);
				Pattern p = Pattern.compile(reg[l]);
				
				for(int m=0; m<list.size(); m++){
					Matcher mat = p.matcher(list.get(m));
					if(mat.matches()){
						s++;
						System.out.println(list.get(m));
					}
				}
				System.out.println(s);
				ss +=s;
			}
			System.out.println(ss);*/
			

			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
