package com.day3;


class Test5 {

	public static void main(String[] args) {

		int i,j;

/*Á÷°¢»ï°¢Çü
		for(i=1; i<=5; i++){

			for(j=1; j<=5-i; j++){
				System.out.print(" "); // °ø¹é ÇÑÄ­
			}

			for(j=1; j<=i; j++){
				System.out.print("*");
			}

			System.out.println();
		}
*/

/* Á¤»ï°¢Çü
		for(i=1; i<=5; i++){

			for(j=1; j<=5-i; j++){
				System.out.print(" "); // °ø¹é ÇÑÄ­
			}

			for(j=1; j<=i*2-1; j++){ // i*2-1 == È¦¼ö ¸¸µå´Â °ø½Ä
				System.out.print("*");
			}

			System.out.println();
		}

*/

/* ¿ª»ï°¢Çü
		for(i=5; i>=1; i--){

			for(j=1; j<=5-i; j++){
				System.out.print(" "); // °ø¹é ÇÑÄ­
			}

			for(j=1; j<=i*2-1; j++){ // i*2-1 == È¦¼ö ¸¸µå´Â °ø½Ä
				System.out.print("*");
			}

			System.out.println();
		}
*/
		for(i=5; i>=1; i--){

			for(j=1; j<=5-i; j++){
				System.out.print(" "); // °ø¹é ÇÑÄ­
			}

			for(j=1; j<=i*2-1; j++){ // i*2-1 == È¦¼ö ¸¸µå´Â °ø½Ä
				System.out.print("*");
			}

			System.out.println();
		}

		for(i=2; i<=5; i++){

			for(j=1; j<=5-i; j++){
				System.out.print(" "); // °ø¹é ÇÑÄ­
			}

			for(j=1; j<=i*2-1; j++){ // i*2-1 == È¦¼ö ¸¸µå´Â °ø½Ä
				System.out.print("*");
			}

			System.out.println();
		}
		
	}
}
