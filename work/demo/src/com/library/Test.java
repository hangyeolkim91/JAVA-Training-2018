package com.library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {

		Calendar cal = new GregorianCalendar(Locale.KOREA);
		cal.setTime(new Date());
		SimpleDateFormat fm = new SimpleDateFormat(
	            "yyyy-MM-dd HHΩ√mm∫–ss√ ");
	    String strDate = fm.format(cal.getTime());
		System.out.println(strDate);
		
		cal.add(Calendar.DAY_OF_YEAR, 7);
		
		strDate = fm.format(cal.getTime());
		System.out.println(strDate);
	}

}
