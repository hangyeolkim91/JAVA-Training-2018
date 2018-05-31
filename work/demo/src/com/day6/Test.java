package com.day6;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] bubble = {10,1,2,6,4,5,7,3,9};
		int[] insert = {10,1,2,6,4,5,7,3,9};
		
		MyBubbleSort bs = new MyBubbleSort();
		
		System.out.println("Bubble sort-----------");
		
		System.out.println("input : " + Arrays.toString(bubble));
		 
		System.out.print("ascending :");
		bs.sort(bubble,"asc");
		//bs.printArray();
		System.out.println(Arrays.toString(bubble));
		System.out.print("dscending : ");
		bs.sort(bubble,"dsc");
		//bs.printArray();
		System.out.println(Arrays.toString(bubble));
		
		System.out.println("Bubble sort end ------------");
		System.out.println();
		
		// ------------------------------------------------
		
		NumberGame ng = new NumberGame();
		
		ng.start();
		System.out.println();
		
		MyInsertionSort is = new MyInsertionSort(insert);
		
		System.out.println("Insertion Sort ============================");
		System.out.println("input : " + Arrays.toString(insert));
		
		System.out.print("ascending : ");
		is.sort("asc");
		is.printArray();
		
		
		System.out.print("dscending : ");
		is.sort("dsc");
		is.printArray();
		

	}

}
