package com.day6;

import java.util.Arrays;

public class MyInsertionSort {

	int[] arr;
	
	public MyInsertionSort(int[] iArr){
		arr = Arrays.copyOf(iArr, iArr.length);
	}
	
	public void sort(String comp){
		if(comp.equalsIgnoreCase("asc")){
			for(int i=1; i<arr.length; i++){
				int curValue = arr[i];
				int aux = i-1;
				while( (aux >=0) && (arr[aux] > curValue)){
					arr[aux+1] = arr[aux];
					aux--;
				}
				arr[aux+1] = curValue;
			}
		}else if ( comp.equalsIgnoreCase("dsc")){
			for(int i=1; i<arr.length; i++){
				int curValue = arr[i];
				int aux = i-1;
				while( (aux >=0) && (arr[aux] < curValue) ){
					arr[aux+1] = arr[aux];
					aux--;
				}
				arr[aux+1] = curValue;
			}
		}else{
			System.out.println("input error");
		}
	}
	
	public void printArray(){
		System.out.println(Arrays.toString(arr));
	}
}
