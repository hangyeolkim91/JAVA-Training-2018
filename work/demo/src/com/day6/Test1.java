package com.day6;

public class Test1 {

	public static void main(String[] args) {
		
		// Bubble sort
		
		int[] num = {36, 30 , 26 , 10 , 4};
		int temp;
		
		System.out.println("Source Data: ");
		for(int i=0; i<num.length; i++){
			System.out.printf("%4d", num[i]);
			
		}
		
		System.out.println();
		
		for(int i=1; i<num.length; i++){
			for(int j=0; j<num.length-i; j++){
				
				if( num[j] > num[j+1]){
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		
		System.out.println("Sorted Data: ");
		for(int i=0; i<num.length; i++){
			System.out.printf("%4d", num[i]);
			
		}
		System.out.println();
	}

}
