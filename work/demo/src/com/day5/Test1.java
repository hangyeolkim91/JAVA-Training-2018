package com.day5;

import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		
		// 배열 안에 있는 숫자를 정렬
		
		Scanner sc = new Scanner(System.in);
		
		int[] ar = new int[5];
		
		int temp;
		
		System.out.print("5개의 정수 입력? ");

		for(int i=0; i<ar.length; i++){
			ar[i] = sc.nextInt();
		}
		
		System.out.print("Source Data : ");
		
		for(int i=0; i<ar.length; i++){
			//System.out.print(ar[i] + " ");
			System.out.printf("%4d", ar[i]);
		}
		System.out.println();
		
		//------------------------------------
		
		
		// Selection Sort
		for(int i=0; i<ar.length; i++){
			for(int j=i+1; j<ar.length; j++){
				if(ar[i] > ar[j]){
					temp = ar[j];
					ar[j]= ar[i];
					ar[i] = temp;
					
				}
			}
		}
		
		
		
		/*for(int i=0; i<ar.length; i++){
			for(int j=0; j<ar.length; j++){
				if(ar[i] < ar[j]){
					temp = ar[j];
					ar[j]= ar[i];
					ar[i] = temp;
					
				}
			}
			for( int k=0; k<ar.length; k++){
				System.out.print(ar[k]+ " ");
			}
			System.out.println();
			
		}*/
		
		
		
		/*for(int i=0; i<ar.length; i++){
			for(int j=0; j<ar.length-1; j++){
				if( ar[j] > ar[j+1]){
					temp = ar[j];
					ar[j]= ar[j+1];
					ar[j+1] = temp;
				}
			}
			
			for( int k=0; k<ar.length; k++){
				System.out.print(ar[k]+ " ");
			}
			System.out.println();
		}*/
		
		//---------------------------------------
		
		System.out.print("Sorted Data : ");
		
		for( int n : ar){
			System.out.printf("%4d", n);
			/*System.out.print(ar[i]+ " ");*/
		}
		
		
		

	}

}
