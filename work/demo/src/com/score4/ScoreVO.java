package com.score4;

public class ScoreVO { // Value Object -> DTO
	
	
	private String name;
	private int kor, eng, math,total;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
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
	public int getTotal() {
		
		total = kor + eng + math;
		
		return total;
	}
	
	@Override
	public String toString() {
		String str=null;
		
		str = String.format("%6s %4d %4d %4d %4d %5.1f", name,kor,eng,math,getTotal(),getTotal()/3.0);
		return str;
	}


	
}
