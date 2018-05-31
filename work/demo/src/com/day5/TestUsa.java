package com.day5;

import com.day6.TestCom;

public class TestUsa {

	public static void main(String[] args) {
		
		TestCom usaTc = new TestCom();
		
		usaTc.input();
		int aa = usaTc.area();
		int ll = usaTc.length();
		usaTc.print(aa, ll);

	}

}
