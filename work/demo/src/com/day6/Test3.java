package com.day6;

import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {

		//배열의 배열
		
		int[][] arr = new int[6][6];
		int n=0;
		
		for(int i=0; i<arr.length-1; i++){
			
			if( i%2 == 0){
				n = i * (arr.length-1);
			}else{
				n = (i+1)*  (arr.length-1) +1;
			}
			
			
			for(int j=0; j<arr.length-1; j++){
				
				//System.out.println(i+" : "+ j);
				if( i%2 == 0){
					n++;
				}else{
					n--;
				}
				
				arr[i][j] = n;
				
				arr[i][5] +=n;
				
				arr[5][j] +=n;
				
				arr[5][5] +=n;
			}
		}
		
		for(int[] i : arr){
			for(int j : i){
				System.out.printf("%4d", j);
			}
			System.out.println();
		}
		
	}

}
