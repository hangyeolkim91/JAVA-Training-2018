package com.rest;

import java.util.Scanner;

public class RestMain {

	public static void main(String[] args) {

		Rest r = new Rest();
		
		r.getXml();
		r.specialInit();
		r.eyoung();
		//r.print();
		
		Scanner sc = new Scanner(System.in);
		
		int ch;
		while(true){
			
			do{
				System.out.println("1.휴게소검색 2.이영자리스트 3.창렬리스트 4.이색휴게소 5.종료");
				ch = sc.nextInt();
			}while(ch <1 || ch>10);
			
			
			if(ch ==1 ){
				System.out.println("1.ㄱ 2.ㄴ 3.ㄷ 4.ㄹ 5.ㅁ 6.ㅂ 7.ㅅ 8.ㅇ 9.ㅈ 10.ㅊ 11.ㅋ 12.ㅌ 13.ㅍ 14.ㅎ");
				ch = sc.nextInt();
				
				r.search(ch);
			}else if ( ch ==2 ){
				r.eyounprint();
			}else if ( ch == 3){
				r.printChang();
			}else if ( ch==4){
				r.printSpecial();
				
			}else if ( ch == 5){
				r.writeFile();
				System.exit(0);
			}
		}
		
	}

}
