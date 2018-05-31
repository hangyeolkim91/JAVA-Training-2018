package com.class3;

// 되부름 함수
// 코드가 간단해짐
// 처리 속도가 느림 (stack 영역에 데이터를 저장했다 출력하기 때문)


public class Test4 {

	public void print(int n){
		if(n != 1){
			
			print(n-1);
		}
		
		System.out.printf("%5d", n);
	}
	
	public int sum(int n){
		return n>1? n+sum(n-1) : n;
		
	}
	
	public int pow(int a, int b){
		return b>=1 ? a*pow(a,b-1) : 1;
	}
	
	public static void main(String[] args) {

		Test4 ob = new Test4();
		ob.print(10);
		System.out.println();
		System.out.println(ob.sum(10));
		System.out.println();
		System.out.println("ob.pow(2,10) : " + ob.pow(2,10));
	}

}
