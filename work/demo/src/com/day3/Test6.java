package com.day3;

class Test6 {

	public static void main(String[] args) {

		//다중 for (3중)
		// 3가지 방법

		
/*		for(int i=0; i<2; i++ ){
			System.out.println((i*4+2) + "단 \t\t" + (i*4+3) + "단 \t\t" + (i*4+4) + "단 \t\t" + (i*4+5) + "단 \t\t");
			for(int j=1; j<10; j++){
				for(int k=0; k<4; k++){
					System.out.print( (i*4+k+2) + " * " + j + " = " + (i*4+k+2)*j + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}*/
		
		
/*		for( int i=0; i<19; i++){
			//System.out.println((i+2) + "단\t\t");
			if( i%10 == 0){
				System.out.println(((2+ 4* (i/10))) +"단\t\t" +((2+ 4* (i/10))+1) +"단\t\t" +((2+ 4* (i/10))+2) +"단\t\t" +((2+ 4* (i/10))+3) +"단\t\t");
				continue;
			}
			for(int j=0; j<4; j++){
				System.out.print(( (2+ 4* (i/10)) +j) + " * " + (i%10) + " = " + ((2+ 4* (i/10))+j)*(i%10)+"\t");
			}
			System.out.println();
			if( i== 9)
				System.out.println();
		}*/
		
	
		
/*		for( int k=0; k<2; k++){
			System.out.println( (4*k+2)+ "단\t\t" + (4*k+3) + "단\t\t" + (4*k+4)+"단\t\t"+ (4*k+5)+"단\t\t");
			for(int l=1; l<10; l++){
				System.out.println( (4*k+2) + " * " + l + " = " + (4*k+2)*l + "\t" + (4*k+3) + " * " + l + " = " + (4*k+3)*l +"\t" + (4*k+4) + " * " + l + " = " + (4*k+4)*l +"\t" + (4*k+5) + " * " + l + " = " + (4*k+5)*l);
			}
		}*/
		
		
	}
}
