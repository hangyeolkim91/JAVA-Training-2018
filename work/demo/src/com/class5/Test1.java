package com.class5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test1 {

	public static void main(String[] args) {

		/*
		 * int a;
		 * double b;
		 * a = 10;
		 * 
		 * b = a;  가능 ( 암시적 형변환 )
		 * 
		 * b = (double) a; (명시적 형변환)
		 * 
		 * a = b;        (x)
		 * a = (int) b;  (o)
		 * ---------------------------------------
		 * 부모(b) - 자식(a)
		 * 
		 * 부모 = 자식;         (o)   UPCAST
		 * 부모 = (부모) 자식;  (o)
		 * 
		 * 자식 = 부모;         (x)   DOWNCAST
		 * 자식 = (자식) 부모;  (o)
		 * 
		 */
		
/*		String a = "";
		Object b;
		b =a;
		Integer c = (Integer) b;
		c.byteValue();
		
		위 코드는 java.lang.ClassCastException을 발생 시키나 컴파일러는 오류를 발생시키지 않음
*/
		
		/*
		 *  Calendar : 현재 시스템의 날짜 및 시간을 관리
		 *  
		 */
		Calendar now = Calendar.getInstance();
		
		//Calendar now1 = new GregorianCalendar();
		
		
		
		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH) + 1;
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(y +"-"+ m+"-"+d);
		System.out.println(w);
		
		String[] week = {"일","월","화","수","목","금","토"};
		
		System.out.println(y +"-"+ m+"-"+d + " " + week[w-1]);
		
		int startDay = now.getActualMinimum(Calendar.DATE);
		int endDay = now.getActualMaximum(Calendar.DATE);
		
		System.out.println("첫날 : "+ startDay);
		System.out.println("말일 : "+ endDay);
		
		System.out.printf("%tF\n", now);
		System.out.printf("%tT\n", now);
		
		System.out.printf("%1$tF %1$tT\n", now);
		
		now.set(2019,10-1,10);
		
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH) + 1;
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(y +"-"+ m+"-"+d + " " + week[w-1]);
		
	}

}
