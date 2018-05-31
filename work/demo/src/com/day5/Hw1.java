package com.day5;

import java.util.Scanner;

public class Hw1 {

	public static void main(String[] args) {
		
		/* 1. 5개의 정수를 입력받아 입력받은 수를 출력하고 입력받은 수중
		 * 가장 큰수와 적은수를 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int[] n = new int[5];
		
		System.out.print("다섯 개의 정수 입력?");
		
		
		for(int i=0; i<5; i++){
			n[i] = sc.nextInt();
		}
		
		for(int i=0; i<n.length; i++){
			System.out.print(n[i] + " ");
		}
		System.out.println();
		for(int i=1; i<n.length; i++){
			int temp = n[i];
			int aux = i-1;
			
			while( (aux>= 0 ) && (n[aux] > temp)){
				n[aux+1] = n[aux];
				aux--;
			}
			n[aux+1] = temp;
		}
		
		
		System.out.println("최소 : " + n[0] + " 최대 : " + n[4]);
		
	}

}
