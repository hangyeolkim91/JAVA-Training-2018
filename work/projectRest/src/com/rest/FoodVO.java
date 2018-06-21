package com.rest;

import java.io.Serializable;

public class FoodVO implements Serializable{

	private int price;
	private String name;
	private int count;
	private double rating;
	private double total;
	private String season;
	
	private boolean isChang;
	private boolean isYoung;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	
	public boolean isChang() {
		return isChang;
	}
	public void setChang(boolean isChang) {
		this.isChang = isChang;
	}
	
	public boolean isYoung() {
		return isYoung;
	}
	public void setYoung(boolean isYoung) {
		this.isYoung = isYoung;
	}
	
	
	@Override
	public String toString() {

		if(name.length() <22){
			while(name.length() <22){
				name += "　"; 
			}
		}
		String str = String.format("%s\t%4s %6d %4s %.2g %6s %2s", name , "가격: " , price , "평점: " , rating , "계절메뉴: " , season);
		 

		
		return str;
	}
	
	
}
