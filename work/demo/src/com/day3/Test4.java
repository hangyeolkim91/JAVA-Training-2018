package com.day3;

class Test4 {

	public static void main(String[] args) {

		// 다중 for 문

		int i, j;

		for( i= 2; i<10; i++){
			System.out.println(i+"단");
			for( j=1; j<10; j++){
				System.out.printf("%d * %d = %d\n" , i , j , i*j);
			}

			System.out.println("--------------------");
		}

		for( int k=0; k<3; k++){
			System.out.println( (3*k+1)+ "단\t\t" + (3*k+2) + "단\t\t" + (3*k+3)+"단\t\t");
			for(int l=1; l<10; l++){
				System.out.println( (3*k+1) + " * " + l + " = " + (3*k+1)*l + "\t" + (3*k+2) + " * " + l + " = " + (3*k+2)*l +"\t" + (3*k+3) + " * " + l + " = " + (3*k+3)*l );
			}
		}
	}
}
