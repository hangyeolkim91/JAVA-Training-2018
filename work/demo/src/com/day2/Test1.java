package com.day2;

class Test1 {

	public static void main(String[] args) {

		//float, double ºñ±³

		float f = 0;
		double d = 0;

		for( int i=1; i<=100000; i++){
			f = f+100000;
			d = d+100000;
		}
		System.out.println("float: " + (f/100000) );
		System.out.println("double: " + (d/100000));
	}
}
