package com.day5;

import java.util.Random;
import java.util.Scanner;

public class Hw3 {

	public static void main(String[] args) {

/*		3. 1~3사이의 난수를 발생시켜 가위,바위,보 게임 프로그램 작성
		  1:가위, 2:바위, 3:보

		예)
		1:가위, 2:바위, 3:보 ?1
		컴퓨터 :보 사람 :가위
		당신이 이겼습니다

		1:가위, 2:바위, 3:보 ?1
		컴퓨터 :바위 사람 :가위
		컴퓨터가 이겼습니다

		1:가위, 2:바위, 3:보 ?1
		컴퓨터 :가위 사람 :가위
		비겼습니다*/
		
		Scanner sc = new Scanner(System.in);
		
		Random rd = new Random();
		
		String[] rsp = {"", "가위", "바위", "보"};
		
		while(true){
			String cmd ="";
			
			int userRsp=0;
			int comRsp = rd.nextInt(3)+1;
			
			System.out.print("1:가위, 2:바위, 3:보?");
			userRsp = sc.nextInt();
			System.out.println("컴퓨터 : " + rsp[comRsp]+ " 사람 : " + rsp[userRsp]);
			if( userRsp == comRsp){
				System.out.println("비겼습니다.");
			}else if (userRsp == 1){
				if( comRsp == 2){
					System.out.println("컴퓨터가 이겼습니다.");
				}else{
					System.out.println("당신이 이겼습니다.");
				}
			}else if ( userRsp == 2){
				if( comRsp == 3){
					System.out.println("컴퓨터가 이겼습니다.");
				}else{
					System.out.println("당신이 이겼습니다.");
				}
			}else if ( userRsp == 3){
				if( comRsp == 1){
					System.out.println("컴퓨터가 이겼습니다.");
				}else{
					System.out.println("당신이 이겼습니다.");
				}
			}
			
			System.out.print("계속 하시겠습니까?[Y/N]");
			cmd = sc.next();
			System.out.println("-----------------------------");
			if( !cmd.equalsIgnoreCase("y")){
				break;
			}
		}
	}

}
