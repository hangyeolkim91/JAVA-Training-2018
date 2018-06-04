package com.score3;

public class ScoreVO { // Value Object -> DTO
	
	private String sid;
	private String name;
	
	private int kor, eng, math,total;

	public void set(String sid, String name, int kor, int eng, int math){
		this.sid = sid;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// getter setter
	
	public String getSid() {
		return sid;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}


	
	public void setSid(String sid){
		this.sid = sid;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setKor(int kor){
		this.kor=kor;
	}
	
	public int getTotal() {
		total = kor+eng+math;
		return total;
	}

	@Override
	public String toString() {
		
		if( sid == null || name == null){
			return null;
		}
		
		int total = getTotal();
		float avg = (float)total/3;
		String str=String.format("%5s %6s %4d %4d %4d %4d %4.1f", sid,name,kor,eng,math,total,avg);

		return str;
	}
}
