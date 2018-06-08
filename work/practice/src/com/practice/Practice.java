package com.practice;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

	//점수가 90이상이면 수
     // 80이상이면 우
      
		Scanner sc = new Scanner(System.in);
		
	    int a;
	    
	    System.out.println("점수입력");
	    a=sc.nextInt();
	    
	    if(a>90){
	    	
	    	System.out.println("수");
	    	
	    }else if(a>80){
	    	
	    	System.out.println("우");
	    	
	    }else if(a>70){
	    	
	    	System.out.println("미");
	    	
	    }else if (a>60){
	    	
	    	System.out.println("양");
	    
	    
	    }else
	    	System.out.println("가");
	    

		
			
	}

}
