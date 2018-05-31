package com.day6;

import java.util.Arrays;

public class MyBubbleSort {

	private int[] arr;
	
	/*public MyBubbleSort(int[] ar){
		
		arr = Arrays.copyOf(ar, ar.length);
		
	}*/
	
	 public void sort(int[] arr, String comp){
		 int temp;
		 if( comp.equalsIgnoreCase("asc")){
			 for(int i=1; i<arr.length; i++){
				 for(int j=0; j<arr.length-i; j++){
					 
					 if(arr[j] > arr[j+1]){
						 
						 temp = arr[j];
						 arr[j] = arr[j+1];
						 arr[j+1] = temp;
					 }
				 }
			 }
		 }else if( comp.equalsIgnoreCase("dsc")){
			 for(int i=1; i<arr.length; i++){
				 for(int j=0; j<arr.length-i; j++){
					 
					 if(arr[j] < arr[j+1]){
						 
						 temp = arr[j];
						 arr[j] = arr[j+1];
						 arr[j+1] = temp;
					 }
				 }
			 }
		 }else{
			 System.out.println("Input error!");
		 }
		 
	 }
	 
	 public void printArray(){
		 
		 if( arr.length != 0 ){
			 System.out.println(Arrays.toString(arr));
		 }
	 }
}
