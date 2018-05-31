package com.class3;

// 비정형 인수


public class Test5 {

	int sum(int...args){
		int s =0;
		for(int i =0; i<args.length; i++){
			s+= args[i];
			
		}
		return s;
	}
	public static void main(String[] args) {
		
		Test5 ob = new Test5();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int[][] arr1 = new int[1][2];
		//System.out.println(ob.sum(1,2,3,4,5,6,7,8,9,10));
		System.out.println(ob.sum(arr));
		//System.out.println(ob.sum(arr1));
	}

}
